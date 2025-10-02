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
        // Map<Integer,Node> map=new HashMap<>();
        // Node newN=new Node(0);
        // Node cur=newN;
        // Node node=head;
        // while(head!=null) {
        //     cur.next=new Node(head.val);
        //     cur=cur.next;
        //     head=head.next;
        //     map.put(cur.val,cur);
        // }
        // cur=newN.next;
        // while(node!=null){
        //     if(node.random!=null)
        //         cur.random=map.get(node.random.val);
        //     cur=cur.next;
        //     node=node.next;
        // }

        // return newN.next;

        Node cur=head;
        Map<Node,Node> map=new HashMap<>();

        while(cur!=null){
            Node newNode=new Node(cur.val);
            map.put(cur,newNode);
            cur=cur.next;
        }

        cur=head;
        while(cur!=null){
            Node node=map.get(cur);
            Node next=map.get(cur.next);
            Node rand=map.get(cur.random);

            node.next=next;
            node.random=rand;
            cur=cur.next;
        }

        return map.get(head);
    }
}