class Solution {
     private static int rec(int nums[],int ind,int memo[]){
         int leave = 0;
         int take = 0;
         int n = nums.length; 
         if(ind>=n) return 0;
         if(memo[ind]!=-1) return memo[ind];
         take = nums[ind] + rec(nums,ind+2,memo);
         leave = rec(nums,ind+1,memo);
         return memo[ind]=Math.max(take,leave);
     }
     public int rob(int[] nums) {
        int n = nums.length;
        int memo[]=new int[n+1];
        Arrays.fill(memo,-1);
        return rec(nums,0,memo);
     }
}