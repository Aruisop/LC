class Solution {
     private static int rec(int i,int j,int[][] grid, int k,int dp[][][]){
      int m = grid.length;
      int n = grid[0].length;
      if(i>=m || j>=n) return Integer.MIN_VALUE;
      int cost = grid[i][j]==0?0:1;
      int score = grid[i][j];
      if(k<cost) return dp[i][j][k]=Integer.MIN_VALUE;
      if(i==m-1 && j==n-1) return dp[i][j][k]=score;
      if(dp[i][j][k]!=-1) return dp[i][j][k];
      int down = rec(i+1,j,grid,k-cost,dp);
      int right = rec(i,j+1,grid,k-cost,dp);
      int best = Math.max(down, right);
      if(best == Integer.MIN_VALUE) return dp[i][j][k]=Integer.MIN_VALUE;
      return dp[i][j][k]=score+best;
     }
     public int maxPathScore(int[][] grid, int k) {
        //TC: O(m*n*k)
        //SC: O(m*n*k)
      int m = grid.length;
      int n = grid[0].length;
      int dp[][][]=new int[m][n][k+1];
      for(int i=0;i<m;i++){
         for(int j=0;j<n;j++){
            Arrays.fill(dp[i][j],-1);
         }
      }
      int ans = rec(0,0,grid,k,dp);
      return ans<0?-1:ans;     
     }
}