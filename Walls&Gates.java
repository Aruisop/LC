// Question is also referred to as: Islands and Treasures on LC
// TC: O(m*n)
// SC: O(m*n)

//Q: 
/*
You are given a m×n 2D grid initialized with these three possible values:

-1 - A water cell that can not be traversed.
0 - A treasure chest.
INF - A land cell that can be traversed. We use the integer 2^31 - 1 = 2147483647 to represent INF.
Fill each land cell with the distance to its nearest treasure chest. If a land cell cannot reach a treasure chest then the value should remain INF.

Assume the grid can only be traversed up, down, left, or right.

Modify the grid in-place.
*/

class Solution {
    public void islandsAndTreasure(int[][] grid) {
          int m=grid.length;
          int n=grid[0].length;
          //bfs from INF wont work as unnecc computations
          //make TC go from O(m*n) {multisrc from 0}
          //all the way to O((m*n)*(m*n)) {ineff af}
          int INF = Integer.MAX_VALUE;
          Queue<int[]>q=new LinkedList<>();
          int dirs[][]={{-1,0},{1,0},{0,-1},{0,1}};
          for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
             if(grid[i][j]==0) q.offer(new int[]{i,j});
             }
          }
          while(!q.isEmpty()){
             int curr[] = q.poll();
             int r = curr[0];
             int c = curr[1];
             for(int d[]:dirs){
                int nr = r+d[0];
                int nc = c+d[1];
                //find the INF val from 0 cell, and update the dist
                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==INF){
                   grid[nr][nc]=grid[r][c]+1;
                   q.offer(new int[]{nr,nc});
                }
             }
          }
    }
}
