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
     private static ListNode merge2(ListNode l1, ListNode l2){
         ListNode dummy = new ListNode(-1);
         ListNode tmp=dummy;
         while(l1!=null && l2!=null){
           if(l1.val<=l2.val){
            tmp.next = l1;
            l1=l1.next;
           }else{
            tmp.next = l2;
            l2=l2.next;
           } 
           tmp=tmp.next;   
         }
         if(l1!=null) tmp.next=l1;
         else tmp.next=l2;
         return dummy.next;
     }
     private static ListNode rec(int lo, int hi,ListNode[]lists){
         //only 1 ele
         if(lo==hi) return lists[lo];
         int mid = lo+(hi-lo)/2;
         ListNode left = rec(lo,mid,lists);
         ListNode right = rec(mid+1,hi,lists);
         ListNode merged = merge2(left,right);
         return merged;
     }
     public ListNode mergeKLists(ListNode[] lists) {
         // space comp comes from the rec stack rewiring nodes, for sp optimizn use Min Heap
         //TC: O(nlogk)
         //SC: O(nlogk)   
         if(lists.length==0) return null;
          //    int lo = 0;
          //    int hi = lists.length-1;
         ListNode res = rec(0,lists.length-1,lists);
         return res;
     }
}