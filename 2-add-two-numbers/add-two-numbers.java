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
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode dummy = new ListNode(0);
       ListNode curr = dummy;
       int carry=0;
       //make sure that carry is added fruitfully
       while(l1!=null || l2!=null || carry!=0){
        int sum=carry;
        if(l1!=null){sum+=l1.val; l1=l1.next;}
        if(l2!=null){sum+=l2.val; l2=l2.next;}
        carry = sum/10;
        int rem = sum%10;
        curr.next = carry>0?new ListNode(rem):new ListNode(sum);
        curr=curr.next;
       }
       return dummy.next;   
     }
}