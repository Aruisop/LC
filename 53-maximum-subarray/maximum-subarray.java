class Solution {
     public int maxSubArray(int[] nums) {
       //O(n),Kadanes algo imp
       int sum = nums[0];
       int maxsum = nums[0];
       int n = nums.length;
       for(int i=1;i<n;i++){
         sum=Math.max(sum+nums[i],nums[i]);
         maxsum=Math.max(maxsum,sum);
       }
       return maxsum;   
     }
}