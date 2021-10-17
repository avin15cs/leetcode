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
        
        ListNode mid= middle(head);
        ListNode rev=reverse(mid);
        
        while(rev!=null){
            if(head.val!=rev.val)
                return false;
            head=head.next;
            rev=rev.next;
        }
        return true;
    }
    public ListNode middle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return slow;
    }
     public ListNode reverse(ListNode mid) {
         
         ListNode cur=mid;
         ListNode prev=null,next=null;
         
         while(cur!=null){
             next=cur.next;
             cur.next=prev;
             
             prev=cur;
             cur=next;
         }
         
         return prev;
         
     }
}