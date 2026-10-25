class Solution {
     int dirs[][]={{-1,0},{1,0},{0,1},{0,-1}};
     public int closedIsland(int[][] grid) {
        // TC: O(m*n)
        // SC: O(m*n)
        int m = grid.length;
        int n = grid[0].length;
        int ct = 0;
        boolean vis[][]=new boolean[m][n];
        for(boolean v[]:vis) Arrays.fill(v,false);
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                 if(grid[i][j]==1 || vis[i][j]) continue;
                 q.offer(new int[]{i,j});
                 vis[i][j]=true;
                 boolean outOfBounds = false;
                 while(!q.isEmpty()){
                  int poll[]=q.poll();
                  int c_i = poll[0];
                  int c_j = poll[1];
                  for(int d[]:dirs){
                    int ni = c_i+d[0];
                    int nj = c_j+d[1];
                    if(ni<0 || nj<0 || ni>=m || nj>=n){
                        outOfBounds=true;
                        continue;
                    }
                    if(!vis[ni][nj] && grid[ni][nj]==0){
                        q.offer(new int[]{ni,nj});
                        vis[ni][nj]=true;
                    } 
                  }
                 }
                 if(!outOfBounds) ct++;
             }
        }
        return ct;
     }
}