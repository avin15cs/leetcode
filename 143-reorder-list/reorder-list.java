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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode second = reverse(slow.next);

        slow.next = null;

        ListNode first = head;

        while(second!=null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second=secondNext;
        }
    }


    ListNode reverse(ListNode node) {
        ListNode prev = null;

        while(node!=null) {
            ListNode temp=node.next;
            node.next = prev;

            prev = node;
            node = temp;
        }

        return prev;
    }
}