class Solution {
     public int longestConsecutive(int[] nums) {
      //BFORCE:
      //TC: O(nlogn)
      //SC: O(1)
      int n = nums.length;
      if(n==0) return 0;
      Arrays.sort(nums);
      //streak and longest is 1 by def
      int streak = 1,longest = 1;
      //streak @ curr ele is dep on the prev ele being -1 of the curr ele
      //in case of sorted..
      for(int i=0;i<n;i++){
          //skip duplis
          if(i>0 && nums[i]==nums[i-1]) continue;
          else if(i>0 && nums[i]==nums[i-1]+1) streak++;
          else streak=1;
          longest = Math.max(longest,streak);
      }
      return longest;   
     }
}