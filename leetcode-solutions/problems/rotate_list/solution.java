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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head==null||head.next==null)  return head;
        
        if(k==0)    return head;
        
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        
        ListNode node=dummy;
        
        int n=0;
        
        while(node.next!=null){
            node=node.next;
            n++;
        }
        k=k%n;
        
        if(k==0) return head;
        
        ListNode prevHead=dummy;
        
        int t=n-k;
        
        while(t!=0){
            prevHead=prevHead.next;
            t--;
        }
        
        ListNode newHead=prevHead.next;
        node.next=head;
        
        prevHead.next=null;
        
        return newHead;
    }
}