class Solution {
     public int maxProduct(int[] nums) {
      //TC: O(n^2)
      //SC: O(1)  
      int n = nums.length;
      if(n==0) return nums[0];
      int max = Integer.MIN_VALUE;
      for(int i=0;i<n;i++){
         int subpr = 1;
         for(int j=i;j<n;j++){
           subpr*=nums[j];
           max = Math.max(subpr,max);
         }
      }
      return max;   
     }
}