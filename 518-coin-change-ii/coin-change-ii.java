class Solution {
     public int change(int amount, int[] coins) {
         //space optimised(unintuitive if 2d dp isnt covered).
         int n = coins.length;
         int dp[]=new int[amount+1];
         dp[0]=1;
         for(int c:coins){
             for(int i=0;i<amount+1;i++){
              if(i-c>=0)  
              dp[i]+=dp[i-c];
             }
         }
         return dp[amount];
     }
}