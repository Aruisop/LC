class Solution {
     public int shortestPathBinaryMatrix(int[][] grid) {
         int n = grid.length;
         int pathzers=1;
         Queue<int[]>q=new LinkedList<>();
         if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
         q.offer(new int[]{0,0});
         //mark it as vis
         grid[0][0]=1;
         int dirs[][]={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
         while(!q.isEmpty()){
             int qsize = q.size();
             for(int i=0;i<qsize;i++){
              int curr[]=q.poll();
              int r=curr[0];
              int c=curr[1];
              if(r==n-1 && c==n-1) return pathzers;
              for(int d[]:dirs){
                 int nr = r+d[0];
                 int nc = c+d[1];
                 if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==0){
                    //mark as vis
                    grid[nr][nc]=1;
                    q.offer(new int[]{nr,nc});
                 }
              }
             }
             pathzers+=1;
         }
       return -1;
     }
}