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
//     public ListNode mergeKLists(ListNode[] lists) {
//         if(lists.length==1)
//             return lists[0];
        
//         if(lists.length==0)
//             return null;
        
//         ListNode head=null;
        
//         for(ListNode list: lists){
//             head=merge(head,list); 
//         }
        
//         return head;
//     }
    
//     private ListNode merge(ListNode l1, ListNode l2){
//         if(l1==null)    return l2;
        
//         if(l2==null)    return l1;
        
//         if(l1.val<=l2.val){
//             l1.next=merge(l1.next,l2);
//             return l1;
//         }
        
//         else{
//             l2.next=merge(l1,l2.next);
//             return l2;
//         }
//     }
    
//     public ListNode mergeKLists(ListNode[] lists) {
//         if(lists.length==1)     return lists[0];
        
//         if(lists.length==0)     return null;
        
//         PriorityQueue<Integer> pq=new PriorityQueue<>();
        
//         for(ListNode list: lists){
            
//             while(list!=null){
//                 pq.add(list.val);
//                 list=list.next;
//             }
//         }
        
//         ListNode dummy=new ListNode(0);
//         ListNode head=dummy;
//         while(!pq.isEmpty()){
//             dummy.next=new ListNode(pq.remove());
//             dummy=dummy.next;
//         }
        
//         return head.next;
//     }
    
    
    public ListNode mergeKLists(ListNode[] lists) {
            
        if(lists.length==1)     return lists[0];
        
        if(lists.length==0)     return null;
        
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->(a.val-b.val));
        
        for(ListNode list: lists){
            if(list!=null)
                pq.add(list);
        }
        
        ListNode head=new ListNode(0);
        ListNode temp=head;
        
        while(!pq.isEmpty()){
            ListNode node=pq.remove();
            
            temp.next=node;
            temp=temp.next;
            
            if(node.next!=null)
                pq.add(node.next);
        }
        
        return head.next;
    }
}