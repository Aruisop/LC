class Solution {
     public int findTargetSumWays(int[] nums, int target) {
       int n = nums.length;
       int totalsum = 0;
       for(int ele:nums){
        totalsum+=ele;
       }
       //0-1 KS logic
     if(Math.abs(target)>totalsum) return 0;
     if((totalsum+target)%2!=0) return 0;   
     int subsetSum = (totalsum+target)/2;
     int dp[][]=new int[n+1][subsetSum+1];
     dp[0][0]=1;
     for(int i=1;i<n+1;i++){
         for(int sub=0;sub<subsetSum+1;sub++){
           int nottake = dp[i-1][sub],take=0;
           if(sub-nums[i-1]>=0) take = dp[i-1][sub-nums[i-1]];
           dp[i][sub]=nottake+take;
         }
     }
     return dp[n][subsetSum];
     }
}