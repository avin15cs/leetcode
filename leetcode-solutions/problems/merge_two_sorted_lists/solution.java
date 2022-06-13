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
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
//         if(list1==null) return list2;
        
//         if(list2==null) return list1;
        
//         if(list1.val<=list2.val){
//             list1.next=mergeTwoLists(list1.next,list2);
//             return list1;
//         }
        
//         else{
//             list2.next=mergeTwoLists(list1,list2.next);
//             return list2;
//         }
//     }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode dummy=new ListNode(0);
        ListNode l=dummy;
        while(l1!=null && l2!=null){
            
            
            if(l1.val<=l2.val){
                l.next=new ListNode(l1.val);
                l1=l1.next;
            }
            else{
                l.next=new ListNode(l2.val);
                l2=l2.next;
            }
            
            l=l.next;
        }
        
        if(l1==null)
            l.next=l2;
            
        if(l2==null)
            l.next=l1;
        
        return dummy.next;
        
    }
}