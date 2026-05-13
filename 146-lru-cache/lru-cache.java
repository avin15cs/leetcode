class LRUCache {
    class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    private int capacity;
    private Node head, tail;

    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        remove(node);

        addNextToHead(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
        }

        Node nNode = new Node(key, value);
        map.put(key, nNode);
        addNextToHead(nNode);
        if(map.size()> capacity) {
            Node last = tail.prev;
            remove(last);
            map.remove(last.key);
        }
            
    }

    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void addNextToHead(Node node) {
        Node next = head.next;

        head.next = node;
        node.next = next;
        next.prev = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */