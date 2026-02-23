class Solution {
     public int findKthLargest(int[] nums, int k) {
         //simple maxheap soln
         PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->(b-a)); 
         for(int ele:nums){
            pq.offer(ele);
         }
         while(!pq.isEmpty() && k>=1){
            if(k==1) return pq.poll();
            pq.poll();
            k--;
         }
         return -1;
     }
}