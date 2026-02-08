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

        if(lists == null)
            return null;

        if(lists.length==1)
            return lists[0];

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode list: lists) {
            if(list!=null)
                pq.add(list);
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(!pq.isEmpty()) {
            ListNode node = pq.remove();
            dummy.next = node;
            dummy=dummy.next;

            node = node.next;
            if(node!=null)
                pq.add(node);
        }

        return head.next;
    }
}