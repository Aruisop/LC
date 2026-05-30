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
     public ListNode reverseBetween(ListNode head, int left, int right) {
          //TC: O(n)
          //SC: O(1)
         if(head==null || left==right) return head;
         ListNode dummy = new ListNode(-1);
         dummy.next = head;
         ListNode beforeLeft = dummy;
         //store the node before left node
         for(int i=1;i<left;i++){
            beforeLeft=beforeLeft.next;
         }      
         ListNode leftNode = beforeLeft.next;
         ListNode prev = null;
         ListNode curr = leftNode;

         //reverse for r-l+1 nodes
         for(int i=0;i<right-left+1;i++){
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
         }
         beforeLeft.next = prev;
         leftNode.next = curr;
         return dummy.next; 
     }
}