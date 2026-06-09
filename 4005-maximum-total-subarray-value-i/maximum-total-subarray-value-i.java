class Solution {
     public long maxTotalValue(int[] nums, int k) {
         //wow
         //TC: O(n)
         //SC: O(1)
         int n = nums.length;
         int max = Integer.MIN_VALUE;
         int min = Integer.MAX_VALUE;
         for(int ele:nums){
            max = Math.max(ele,max);
         }
         for(int ele:nums){
            min = Math.min(ele,min);
         }
         return (long)(max-min)*k;
         }
}