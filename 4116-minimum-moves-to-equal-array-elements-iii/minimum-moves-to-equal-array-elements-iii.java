class Solution {
     public int minMoves(int[] nums) {
         int max = 0;
         for(int ele:nums){
            max = Math.max(max,ele);
         }
         int sum = 0;
         for(int ele:nums){
            sum+=max-ele;
         }
         return sum;
     }
}