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
     public int[] nodesBetweenCriticalPoints(ListNode head) {
          //Bru-Force
          //TC: O(n)
          //SC: O(n)
         ArrayList<Integer>al=new ArrayList<>();
         ListNode temp = head;
         while(temp!=null){
             al.add(temp.val);
             temp=temp.next;
         }
         int n = al.size();
         if(n<=2) return new int[]{-1,-1};
        //  System.out.println(al);
         ArrayList<Integer>criticalpts=new ArrayList<>();
         for(int i=0;i<n;i++){
             if( (i>0 && i<n-1) && ( (al.get(i-1)>al.get(i) && al.get(i)<al.get(i+1)) || (al.get(i-1)<al.get(i) && al.get(i+1)<al.get(i)) ) ){
               criticalpts.add(i);
              }
             }
             int ans[]=new int[2];
             if(criticalpts.size()<2) return new int[]{-1,-1};
             System.out.println(criticalpts);
             int min = Integer.MAX_VALUE;
             //criticalpts is alr sorted by default
             for(int i=1;i<criticalpts.size();i++){
                int diff = criticalpts.get(i)-criticalpts.get(i-1);
                min = Math.min(min,diff);
             }
             //get max by subbing the largest val in the cpts arr and the smallest value ie 0
              int max = criticalpts.get(criticalpts.size()-1)-criticalpts.get(0);
              //init bru-force approach of finding all differences
              //didnt realise that c_pts is already sorted

                //  int max = Integer.MIN_VALUE;
                //  int min = Integer.MAX_VALUE;
                //  for(int ele:c_pts_diff){
                //      if(ele>0){
                //         min = Math.min(min,ele);
                //         max = Math.max(max,ele);
                //      }
                //   }

                ans[0]=min;
                ans[1]=max;  
            //   for(int ele:ans) System.out.println(ele);
              return ans;
     }
}