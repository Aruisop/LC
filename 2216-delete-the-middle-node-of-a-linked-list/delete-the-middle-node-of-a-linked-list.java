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
     public ListNode deleteMiddle(ListNode head) {
         //Optimised Commit
         //TC: O(n)
         //SC: O(1)
         if(head==null) return null;
         if(head.next==null) return null;
         ListNode slow =head,fast=head;
         ListNode slowprev = null;
         while(fast!=null && fast.next!=null){
          slowprev=slow;
          slow = slow.next;
          fast = fast.next.next;
          }
          slowprev.next = null;
          slowprev.next=slow.next;
          return head; 

     }
}