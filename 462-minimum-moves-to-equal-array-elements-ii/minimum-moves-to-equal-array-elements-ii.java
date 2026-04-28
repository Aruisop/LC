class Solution {
     public int minMoves2(int[] nums) {
         //Pattern: Sorting+ct using median
         //TC: O(n)
         //SC: O(1)
         int n = nums.length;
         //make sure to sort prior
         Arrays.sort(nums);
         int median = nums[n/2];
         int ct = 0;
         //exact same logic is applicable to LC: 2033. Minimum Operations to Make a Uni-Value Grid
         for(int i=0;i<n;i++){
            // '/1' and '%1' is setup intentionally in order for better understanding in problem
            // above
            if(Math.abs(nums[i]-median)%1!=0) return -1;
            ct+=Math.abs(nums[i]-median)/1;
         }
         return ct;
     }
}