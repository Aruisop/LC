class Solution {
     public int numEnclaves(int[][] grid) {
          int m = grid.length;
          int n = grid[0].length;
          Queue<int[]>q=new LinkedList<>();
          int dirs[][]={{1,0},{0,1},{0,-1},{-1,0}};
          for(int i=0;i<m;i++){
           if(grid[i][0]==1){
            grid[i][0]=0; 
            q.offer(new int[]{i,0});
           }
           if(grid[i][n-1]==1){
            grid[i][n-1]=0; 
            q.offer(new int[]{i,n-1});
           }
          } 
          for(int j=0;j<n;j++){
             if(grid[0][j]==1){
                grid[0][j]=0; 
                q.offer(new int[]{0,j});
             } 
             if(grid[m-1][j]==1){
                grid[m-1][j]=0; 
                q.offer(new int[]{m-1,j});
             }
          }
          while(!q.isEmpty()){
             int curr[] = q.poll();
             int i =curr[0];
             int j=curr[1];
             for(int d[]:dirs){
                 int ni = i+d[0];
                 int nj = j+d[1];
                 if(ni>=0 && ni<m && nj>=0 && nj<n && grid[ni][nj]==1){
                    grid[ni][nj]=0;
                    q.offer(new int[]{ni,nj});
                 }
             }
          }
          //end of the grid
          int enclaves=0;
          for(int i=1;i<m-1;i++){
             for(int j=1;j<n-1;j++){
              if(grid[i][j]==1) enclaves++;
             }
          }
          return enclaves;
     }
}