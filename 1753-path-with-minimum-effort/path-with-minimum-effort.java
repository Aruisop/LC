class Solution {
     public int minimumEffortPath(int[][] heights) {
        //Approach1 is Djikstras (2 is Bs+Bfs {unintuitive})
     int m = heights.length;
     int n = heights[0].length;
     int dist[][]=new int[m][n];
     for(int d[]:dist) Arrays.fill(d,Integer.MAX_VALUE);
     PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->(a[2]-b[2]));
     int dirs[][]={{1,0},{-1,0},{0,1},{0,-1}};
     pq.offer(new int[]{0,0,0});
     while(!pq.isEmpty()){
         int curr[]=pq.poll();
         int r = curr[0];
         int c = curr[1];
         int cost = curr[2];
         if(r==m-1 && c==n-1) return cost;
         for(int dir[]:dirs){
             int nr = r+dir[0];
             int nc = c+dir[1];
             if(nr>=0 && nr<m && nc>=0 && nc<n){
                 int newcost = Math.max(cost,Math.abs(heights[nr][nc]-heights[r][c]));
                     if(newcost<dist[nr][nc]){
                       dist[nr][nc]=newcost;
                       pq.offer(new int[]{nr,nc,newcost});
                     }
             }
         }
      }
      return -1;    
     }
}