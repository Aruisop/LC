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
     public int pairSum(ListNode head) {
          //BFORCE, unoptimal
          //TC: O(n)
          //SC: O(n)
         if(head==null) return -1;
         List<Integer>al = new ArrayList<>();
         ListNode temp = head;
         while(temp!=null){
          al.add(temp.val);  
          temp = temp.next;
         }
         //got the size{even}
         int n = al.size();
         //next identify valid nodes+twins, and store their sums
         //find the sum and store for each node
         List<Integer>twinsum = new ArrayList<>();
         HashSet<Integer>hs=new HashSet<>();
         for(int i=0;i<n;i++){
             int twinind = n-1-i;
             if(twinind>=0 && twinind<n && !hs.contains(twinind)){
                twinsum.add(al.get(i)+al.get(twinind));
                hs.add(i);
                hs.add(twinind);
             }
         }
         int max = Integer.MIN_VALUE;
         for(int ele:twinsum){
           max = Math.max(max,ele);
         }
         return max;
     }
}