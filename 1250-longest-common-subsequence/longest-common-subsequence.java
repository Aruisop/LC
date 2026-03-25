class Solution {
     public int longestCommonSubsequence(String text1, String text2) {
         //Most optimal,dp 
         //TC: O(m*n)
         //SC: O(m*n)
         int m = text1.length();
         int n = text2.length();
         int dp[][]=new int[m+1][n+1];
         for(int i=1;i<m+1;i++){
             for(int j=1;j<n+1;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
             } 
         }
         return dp[m][n];      
     }
}