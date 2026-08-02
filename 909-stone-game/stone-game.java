class Solution {
     public boolean stoneGame(int[] piles) {
         int n = piles.length;
         int dp[][]=new int[n][n];
         for(int i=0;i<n;i++){
         dp[i][i] = piles[i];
         }
         for(int leng=2;leng<=n;leng++){
             for(int l=0;l<n-leng+1;l++){
               int r = leng+l-1;
               dp[l][r] = Math.max(piles[l]-dp[l+1][r],piles[r]-dp[l][r-1]);
             } 
         }
         return dp[n-1][n-1]>=0;   
     }
}