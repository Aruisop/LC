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
     public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode temp=head;
      int ct=0;
      int noofnd=0;
      while(temp!=null){
         noofnd++;
         temp=temp.next;
      }
      temp=head;
       //one trivial edge case, not too much of an issue
      //is that if noofnd==n then delete the head itself
      if(noofnd==n) return head.next;
      while(temp!=null && ct<=noofnd-n-2){
        temp=temp.next;
        ct++;
      }
      if(temp!=null && temp.next!=null)temp.next=temp.next.next;
      return head;   
     } 
}