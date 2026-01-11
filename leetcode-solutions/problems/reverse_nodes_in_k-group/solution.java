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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode node = head;
        while(count < k) {
            if(node == null)
                return head;
            node = node.next;
            count++;
        }

        ListNode prev = reverseKGroup(node, k);
        
        while(count>0) {
            ListNode temp = head.next;
            head.next = prev;

            prev = head;
            head = temp;
            count--;
        }

        return prev;
    }
}