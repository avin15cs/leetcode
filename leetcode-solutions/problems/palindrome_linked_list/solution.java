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
    public boolean isPalindrome(ListNode head) {
        ListNode fast=head,slow=head;

        while(fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode mid=slow;
        ListNode prev=null;

        while(mid!=null) {
            ListNode temp=mid.next;
            mid.next=prev;

            prev=mid;
            mid=temp;
        }

        while(prev!=null && head!=null) {
            if(prev.val!=head.val)
                return false;
            
            prev=prev.next;
            head=head.next;
        }
        return true;
    }
}