/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node cur=head;
        Map<Node,Node> map=new HashMap<>();

        while(cur!=null) {
            Node node = new Node(cur.val);
            map.put(cur,node);
            cur=cur.next;
        }

        cur=head;
        while(cur!=null) {
            Node node = map.get(cur);
            Node next = map.get(cur.next);
            Node random = map.get(cur.random);

            node.next = next;
            node.random = random;

            cur = cur.next;
        }

        return map.get(head);
    }
}