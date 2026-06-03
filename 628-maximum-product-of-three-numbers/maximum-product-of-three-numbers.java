class Solution {
     public int maximumProduct(int[] nums) {
         //TC: O(nlogn)
         //SC: O(1)
         //took way longer than expected :( 
         Arrays.sort(nums);
         //[-3,-2,-1]
         //[1,2,3,4]
         int n = nums.length;
         if(n<3) return -1;
         int negprod = nums[0]*nums[1];
          return Math.max(negprod*nums[n-1],nums[n-1]*nums[n-2]*nums[n-3]);
     }
}