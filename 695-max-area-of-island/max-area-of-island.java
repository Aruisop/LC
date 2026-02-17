class Solution {
     private static int dfs(int i, int j, int grid[][],boolean vis[][]){
         int m = grid.length;
         int n = grid[0].length;
         if(i<0 || i>=m || j<0 || j>=n || vis[i][j] || grid[i][j]==0) return 0;
         int area=1;
         vis[i][j]=true;
         area+=dfs(i+1,j,grid,vis);
         area+=dfs(i,j+1,grid,vis);
         area+=dfs(i-1,j,grid,vis);
         area+=dfs(i,j-1,grid,vis);
         return area;
     }
     public int maxAreaOfIsland(int[][] grid) {
         int m = grid.length;
         int n = grid[0].length;
         boolean vis[][]=new boolean[m][n];
         int max = Integer.MIN_VALUE;
         for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                 if(!vis[i][j] && grid[i][j]==1){
                   int area = dfs(i,j,grid,vis);
                   max=Math.max(max,area);
                 }
             }
         }
         return max==Integer.MIN_VALUE?0:max;
     }
}