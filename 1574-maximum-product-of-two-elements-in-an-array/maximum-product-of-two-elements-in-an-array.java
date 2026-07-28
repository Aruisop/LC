class Solution {
     public int maxProduct(int[] nums) {
         // Optimal, works because no -ve nos are in array
         //TC: O(n*logn)
         // SC: O(1)  
         int n = nums.length;
         Arrays.sort(nums);
         return (nums[n-2]-1)*(nums[n-1]-1);   
     }
}