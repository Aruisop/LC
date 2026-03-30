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
     private static ListNode reverseLL(ListNode temp){
         ListNode curr = temp;
         ListNode prev = null;
         while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
         } 
         return prev;
     }
     private static ListNode getkthNode(ListNode temp, int k){
         k--;
         while(temp!=null && k>0){
            k--;
            temp=temp.next;
         }
         return temp;
     }
     public ListNode reverseKGroup(ListNode head, int k) {
          //TC: O(n)
          //SC: O(1)
          //Unintuitive
         if(head==null || k==1) return head;
         ListNode temp=head;
         ListNode prevNode = null;
         while(temp!=null){
             ListNode kthNode = getkthNode(temp, k);
             if(kthNode==null){
                 if(prevNode!=null)prevNode.next=temp;
                 break;
             }
             ListNode nextNode = kthNode.next;
             kthNode.next = null;
             ListNode revHead = reverseLL(temp);
             if(temp==head){
                head = revHead;
             }else{
               prevNode.next = revHead;  
             }
             prevNode = temp;
             temp = nextNode;
         }
         return head;
     } 
}