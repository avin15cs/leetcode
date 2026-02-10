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
    // public ListNode oddEvenList(ListNode head) {
    //     ListNode odd = new ListNode(0);
    //     ListNode even = new ListNode(0);
    //     ListNode d1 = odd;
    //     ListNode d2 = even;

    //     while(head!=null) {
    //         odd.next = head;
    //         odd = odd.next;

    //         if(head.next!=null) {
    //             even.next = head.next;
    //             even=even.next;

    //             head = head.next.next;
    //             even.next = null;
    //         } else {
    //             head = head.next;
    //         }
    //         odd.next = null;
    //     }

    //     odd.next = d2.next;

    //     return d1.next;

    // }

    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;
        ListNode odd = head, even = head.next, evenHead = even;
        while(even!=null && even.next!=null) {
            odd.next = odd.next.next;
            odd=odd.next;

            even.next = even.next.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}