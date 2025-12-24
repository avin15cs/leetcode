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
    public ListNode removeNthFromEnd(ListNode head, int k) {
        if (head == null) 
            return null;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy;
        ListNode slow=dummy;
        int n=0;
        while(n<k) {
            fast=fast.next;
            n++;
        }

        while(fast.next!=null) {
            fast=fast.next;
            slow=slow.next;
        }

        slow.next=slow.next.next;

        return dummy=dummy.next;

    }
}