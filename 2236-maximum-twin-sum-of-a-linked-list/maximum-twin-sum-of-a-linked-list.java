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
     private static ListNode rev(ListNode head){
         ListNode prev = null;
         ListNode curr = head;
         while(curr!=null){
             ListNode nxt = curr.next;
             curr.next = prev;
             prev = curr;
             curr = nxt;
         } 
         return prev;
      }
     public int pairSum(ListNode head) {
         //Optimal
         //TC: O(n)
         //SC: O(1)
         ListNode slow = head;
         ListNode fast = head;
         while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
         }
         ListNode second = rev(slow);
         ListNode first = head;
         int maxsum  = Integer.MIN_VALUE;
         while(second!=null){
            maxsum = Math.max(maxsum,first.val+second.val);
            first=first.next;
            second=second.next;
         }
         return maxsum;
     }
}