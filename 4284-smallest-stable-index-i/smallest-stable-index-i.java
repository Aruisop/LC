class Solution {
     private static int findMinTill_n_from_i(int nums[], int i){
         int n = nums.length;
         int min = Integer.MAX_VALUE;
         for(int j=i;j<n;j++){
           min = Math.min(min,nums[j]);
         }
         return min;
     }
     private static int findMaxTill_i(int nums[], int i){
         int max = Integer.MIN_VALUE;
         for(int j=0;j<=i;j++){
             max = Math.max(max,nums[j]);
         }
         return max;
     }
     public int firstStableIndex(int[] nums, int k) {
         //Bru-Force
         int n = nums.length;
         int fmti = -1;
         int fmtnfi = -1;
         int smallestInstabilityIndex = Integer.MAX_VALUE;
         for(int i=0;i<n;i++){
           fmti = findMaxTill_i(nums,i);
           fmtnfi  = findMinTill_n_from_i(nums,i);
           if((fmti-fmtnfi)<=k){
            smallestInstabilityIndex = Math.min(smallestInstabilityIndex,i);
           }
         }
         return smallestInstabilityIndex==Integer.MAX_VALUE?-1:smallestInstabilityIndex;
     }
}