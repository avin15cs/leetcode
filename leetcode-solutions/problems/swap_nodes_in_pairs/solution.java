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
    public ListNode swapPairs(ListNode head) {

        if(head==null||head.next==null) return head;

        ListNode dummy=new ListNode(0);
        dummy.next=head;

        ListNode prev=dummy;
        ListNode cur=prev.next;
        ListNode next=cur.next;

        while(next!=null){
            prev.next=cur.next;
            cur.next=next.next;
            next.next=cur;

            if(cur==null||cur.next==null)   break;
            
            prev=cur;
            cur=cur.next;
            next=cur.next;

        }

        return dummy.next;
    }
}