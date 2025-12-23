// class LRUCache {
//     private class Node {
//         int key, value;
//         Node prev, next;
//         Node(int k, int v) {
//             key = k;
//             value = v;
//         }
//     }

//     private HashMap<Integer,Node> cache;
//     private Node head,tail;
//     private int capacity;
//     public LRUCache(int capacity) {
//         this.capacity=capacity;
//         cache=new HashMap<>();
//         head=new Node(0,0);
//         tail=new Node(0,0);
//         head.next=tail;
//         tail.prev=head;
//     }
    
//     public int get(int key) {
//         if (!cache.containsKey(key)) return -1;
//         Node node = cache.get(key);
//         remove(node);
//         insertToHead(node);
//         return node.value;
//     }
    
//     public void put(int key, int value) {
//         if(cache.containsKey(key)) {
//             Node node = cache.get(key);
//             node.value=value;
//             remove(node);
//             insertToHead(node);
//         } else {
//             Node node = new Node(key,value);
//             cache.put(key, node);
//             insertToHead(node);
//             if(cache.size()>capacity) {
//                 Node lru = tail.prev;
//                 remove(lru);
//                 cache.remove(lru.key);
//             }
//         }
//     }

//     private void remove(Node node) {
//         node.prev.next = node.next;
//         node.next.prev = node.prev;
//     }

//     private void insertToHead(Node node) {
//         node.next = head.next;
//         node.prev = head;
//         head.next.prev = node;
//         head.next = node;
//     }
// }

class LRUCache {

    int capacity;
    Queue<Integer> q = new ArrayDeque<>();
    Map<Integer, Integer> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        q.remove(key);     // O(n)
        q.offer(key);      // MRU
        return map.get(key);
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            q.remove(key);
            q.offer(key);
        } else {
            if (map.size() == capacity) {
                int lruKey = q.poll();
                map.remove(lruKey);
            }
            q.offer(key);
        }

        map.put(key, value);
    }
}
