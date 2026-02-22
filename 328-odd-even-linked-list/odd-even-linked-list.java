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
     public ListNode oddEvenList(ListNode head) {
         if(head==null) return null;
         ListNode tmp = head;
         //dummy nodes for odd abnd even indices
         ListNode oddHead = new ListNode(-1);
         ListNode evenHead = new ListNode(-1);
         ListNode oddTail = oddHead;
         ListNode evenTail = evenHead;
         int pos=1;
         while(tmp!=null){
         //odd indices first
         if(pos%2!=0){
           oddTail.next = tmp;
           oddTail=oddTail.next;
         }else{
            evenTail.next = tmp;
            evenTail=evenTail.next;
         }
         pos++;
         tmp=tmp.next;
         }
         oddTail.next = evenHead.next;
         evenTail.next=null;  
         return oddHead.next;  
     }
}