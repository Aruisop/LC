class Solution {
    //  private static int rec(int amount, int[] coins,int ind,int memo[][]){
    //    int n = coins.length;
    //    if(ind>=n) return 0;
    //    if(amount==0) return 1;
    //    if(memo[amount][ind]!=-1) return memo[amount][ind];
    //    int nottake = rec(amount,coins,ind+1,memo);
    //    int take=0;
    //    if(amount-coins[ind]>=0)
    //    take = rec(amount-coins[ind],coins,ind,memo);
    //    return memo[amount][ind]=nottake+take; 
    //  }
     public int change(int amount, int[] coins) {
         //pure dp (intuitive)
         int n = coins.length;
         int dp[][]=new int[amount+1][n+1];
         //for amount 0, all j indices (for coins) will have only 1 possiblity.
         for(int j=0;j<n+1;j++){
            dp[0][j]=1;
         }
         for(int i=1;i<amount+1;i++){
             for(int j=1;j<n+1;j++){
              int leave = dp[i][j-1],take=0;
              if(i-coins[j-1]>=0) take = dp[i-coins[j-1]][j];   
              dp[i][j]=leave+take;
             }
         }
         return dp[amount][n];
     }
}