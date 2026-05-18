class Solution {
     public int removeDuplicates(int[] nums) {
      //O(n) TC
      //O(1) SC  
      int n = nums.length;
      int k = 2;
      for(int i=2;i<n;i++){
         if(nums[k-2]!=nums[i]){
            nums[k]=nums[i];
            k++;
         }
      }
      return k;
     }
}