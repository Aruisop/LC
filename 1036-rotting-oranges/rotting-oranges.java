class Solution {
     public int orangesRotting(int[][] grid) {
      int time = 0;
      int m = grid.length;
      int n = grid[0].length;
      int freshct=0;
      Queue<int[]>q=new LinkedList<>();
      for(int i=0;i<m;i++){
         for(int j=0;j<n;j++){
          if(grid[i][j]==1)freshct++;
          if(grid[i][j]==2) q.offer(new int[]{i,j});
         }
      }
      int dirs[][]={{1,0},{-1,0},{0,1},{0,-1}};
      while(!q.isEmpty() && freshct>0){
         int qsize = q.size();
         for(int i=0;i<qsize;i++){
             int arr[]=q.poll();
             int u = arr[0];
             int v = arr[1];
             for(int d[]:dirs){
                 int nu = u + d[0];
                 int nv = v + d[1];
                 if(nu>=0 && nu<m && nv>=0 && nv<n && grid[nu][nv]==1){
                    grid[nu][nv]=2;
                    freshct--;
                    q.offer(new int[]{nu,nv});
                 }
             }            
         }
         time++; 
      }
      return freshct==0 ?time:-1;
     }
}