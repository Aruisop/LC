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
     public ListNode mergeKLists(ListNode[] lists) {
         //space optimised O(k) solution with min heap
         //TC: O(nlogk)
         int n = lists.length;
         if(lists.length==0) return null;
         PriorityQueue<ListNode>pq=new PriorityQueue<>((a,b)->(a.val-b.val));
         for(ListNode ele:lists){
         if(ele!=null)
         pq.offer(ele);
         }
         ListNode dummy = new ListNode(-1);
         ListNode tail = dummy;
       while(!pq.isEmpty()){
         ListNode top = pq.poll();
         tail.next = top;
         tail=top;
         if(top.next!=null){
            pq.offer(top.next);
         }
       }
       return dummy.next;
     }
}