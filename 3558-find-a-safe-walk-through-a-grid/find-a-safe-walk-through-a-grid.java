class Solution {
     final static int dirs[][]= {{-1,0},{1,0},{0,1},{0,-1}};
     private static boolean isSafeCell(int mat[][], int i, int j){
        int m = mat.length;
        int n = mat[0].length;
        return (i>=0 && j>=0 && i<m && j<n);
     }
     public boolean findSafeWalk(List<List<Integer>> grid, int health) {
         //TC: O(mn*logn)
         //SC: O(m*n)
         int m = grid.size();
         int n = grid.get(0).size();
         int dist[][]=new int[m][n];
         for(int r[]:dist){
          Arrays.fill(r, Integer.MAX_VALUE);
         }
         PriorityQueue<int[]>pq=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
         dist[0][0]=grid.get(0).get(0);
         pq.offer(new int[]{dist[0][0],0,0});
         while(!pq.isEmpty()){
             int curr[]=pq.poll();
             int damage_to_reach_curr_cell = curr[0];
             int i = curr[1];
             int j = curr[2];
             if(damage_to_reach_curr_cell>dist[i][j]) continue;
             for(int dir[]:dirs){
                 int di = i+dir[0];
                 int dj = j+dir[1];
                 if(isSafeCell(dist,di,dj)){
                     int new_damage = damage_to_reach_curr_cell+grid.get(di).get(dj);
                     if(new_damage<dist[di][dj]){
                       dist[di][dj] = new_damage;
                       pq.offer(new int[]{new_damage,di,dj}); 
                     }
                 } 
             }
         }
         return (dist[m-1][n-1]<health);     
     }
}