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
         if(head==null || head.next==null) return null;
         ListNode temp = head;
         int n = 0;
         while(temp!=null){
            n++;
            temp=temp.next;
         }
         if(n==1) return null;
         temp=head;
         //safest instead of l+(r-l)/2
         int middle = n/2;
         ListNode curr=temp;
         int idx=0;
         while(temp!=null){
            //stop one before the middle and delete the middle
           if(idx==middle-1){
             ListNode mid = temp.next;
             ListNode nexttomid = mid.next;
             temp.next = nexttomid;
             mid.next=null;
           }
           temp=temp.next;
           idx++;
         }
         return curr;
     }
}