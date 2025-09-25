/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast= new ListNode(0);
        fast.next=head;

        ListNode slow=new ListNode(0);
        slow.next=head;

        while(fast!=null && fast.next!=null) {

            fast=fast.next.next;
            slow=slow.next;

            if(fast==slow) return true;

        }

        return false;
    }
}