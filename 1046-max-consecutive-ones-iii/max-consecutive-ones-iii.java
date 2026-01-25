class Solution {
     public int longestOnes(int[] nums, int k) {
         //invariant here is to recognize that at any given pt we cant have more than k 0s in the window
         int n = nums.length;
         int zerct = 0;
         int max = 0;
         int l = 0, r = 0;
         while(r<n){
           if(nums[r]==0) zerct++;
           while(zerct>k){
             if(nums[l]==0){
               zerct--;
             } 
             l++;
             }
          max = Math.max(max, r-l+1);
          r++;
         }
         return max;
     }
}