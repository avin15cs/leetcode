class LRUCache {
    private class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private HashMap<Integer,Node> cache;
    private Node head,tail;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        remove(node);
        addToHead(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;

            remove(node);
            addToHead(node);

            return;
        }

        if(cache.size()==capacity) {
            Node node = tail.prev;
            remove(node);
            cache.remove(node.key);
        }

        Node node = new Node(key, value);
        cache.put(key,node);
        addToHead(node);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}
