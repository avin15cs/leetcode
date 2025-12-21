/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;

        if(n==0)
            return null;

        if(n==1)
            return lists[0];

        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)-> a.val-b.val);

        for(ListNode list: lists) {
            if(list!=null)
                pq.add(list);
        } 

        ListNode head=new ListNode(0);

        ListNode dummy=head;

        while(!pq.isEmpty()) {
            ListNode node=pq.remove();
            
            head.next=node;
            head=head.next;

            if(node.next!=null)
                pq.add(node.next);

        }

        return dummy.next;
    }
}