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
        
        Node node = head;
        Map<Node, Node> map = new HashMap<>();

        while(node != null) {
            Node newNode = new Node(node.val);
            map.put(node,newNode);
            node = node.next;
        }

        node = head; 
        while(node!=null) {
            Node curNode = map.get(node);

            Node nextNode = map.get(node.next);

            Node random = map.get(node.random);

            curNode.next = nextNode;
            curNode.random = random;

            node = node.next;
        }
        
        return map.get(head);
    }
}