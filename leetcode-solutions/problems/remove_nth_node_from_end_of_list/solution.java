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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode second=new ListNode(0);
        second.next=head;
        
        ListNode first=second;
        ListNode dummy=first;
        int k=0;
        while(k!=n){
            second=second.next;
            k++;
        }
        
        while(second.next!=null){
            first=first.next;
            second=second.next;
        }
        
        first.next=first.next.next;
        
        return dummy.next;
    }
}