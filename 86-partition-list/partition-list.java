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
     public ListNode partition(ListNode head, int x) {
         //TC: O(n)
         //SC: O(n)
         ArrayList<Integer>sm=new ArrayList<>();
         ArrayList<Integer>gr=new ArrayList<>();
         ListNode temp = head;
         while(temp!=null){
             if(temp.val<x){
               sm.add(temp.val);
              }else{
                 // >= case, includes even the case where 
                 // x is included to count for relative ordering 
                 gr.add(temp.val);
                 }  
          temp = temp.next;
         }
         List<Integer>ans = new ArrayList<>();
         for(int i=0;i<sm.size();i++){
            ans.add(sm.get(i));
         }
         for(int i=0;i<gr.size();i++){
            ans.add(gr.get(i));
         }
         if(head==null) return null;
         ListNode newHead = new ListNode(ans.get(0));
         ListNode newTemp = newHead;
         for(int i=1;i<ans.size();i++){
            ListNode nextnode = new ListNode(ans.get(i));
            newTemp.next = nextnode;
            newTemp = newTemp.next;
         }
         return newHead;
     }
}