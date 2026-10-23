class Solution {
     public int sortPermutation(int[] nums) {
       int n = nums.length;
       int ands = -1;
       int sorted = 0;
       for(int i=0;i<n;i++){
         if(nums[i]==i) sorted++;
         else{
           ands&=nums[i];
         }
       }
       if(sorted==n) return 0;
       return ands;   
     }
}