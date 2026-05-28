class Solution {
     public boolean check(int[] nums) {
         //Optimised
         //TC: O(n)
         //SC: O(1)
         int n = nums.length;
         int drop = 0;
         for(int i=0;i<n;i++){
          if(nums[i]>nums[(i+1)%n]) drop++;
         }
         //the number of such drops can only be 1 or 0.
         //for rotated and sorted
         return drop<=1;
     }
}