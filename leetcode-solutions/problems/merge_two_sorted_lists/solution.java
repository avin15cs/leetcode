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
    // public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    //     if(list1==null) return list2;
        
    //     if(list2==null) return list1;

    //     if(list1.val<=list2.val) {
    //         list1.next = mergeTwoLists(list1.next,list2);
    //         return list1;
    //     }

    //     else {
    //         list2.next = mergeTwoLists(list1,list2.next);
    //         return list2;
    //     }
    // }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list = new ListNode(0);
        ListNode start = list;
        while(list1!=null && list2!=null) {
            if(list1.val <= list2.val) {
                list.next=new ListNode(list1.val);
                list1=list1.next;
            }
            else {
                list.next=new ListNode(list2.val);
                list2=list2.next;
            }
            list=list.next;
        }

        if(list2==null) {
            list.next=list1;
        }
        else {
            list.next = list2;
        }
        return start.next;
    }
}