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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||head.next==null||left==right)
            return head;

        
        ListNode prev = null, cur = head;
        int i=1;
        while(cur!=null && i!=left) {
            prev = cur;
            cur = cur.next;
            i++;
        }

        ListNode pointerToStart = prev;
        prev = null;

        ListNode start = cur;

        while(cur!=null && i!=right+1) {
            ListNode next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;

            i++;
        }

        start.next = cur;
        if(pointerToStart!=null)
            pointerToStart.next = prev;

        else 
            return prev;  //if left is index 0 then it will become a new head

        return head;

    }
}