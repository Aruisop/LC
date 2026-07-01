class Solution {
     final static int dirs[][] = {{0,-1},{0,1},{1,0},{-1,0}};
     private static boolean isValidCell(int matrix[][],int i, int j){
         int n=matrix.length;
         return (i>=0 && j>=0 && i<n && j<n);
     }
     private static boolean isValidPathBfs(int matrix[][], int val){
         //check if it possible to start and end 
         int n = matrix.length;
         if(matrix[0][0]<val || matrix[n-1][n-1]<val) return false;
         //keep track of the cells visited
         boolean vis[][]=new boolean[n][n];
         Queue<int[]>trav_q = new LinkedList<>();
         trav_q.offer(new int[]{0,0});
         vis[0][0]=true;
         while(!trav_q.isEmpty()){
             int curr[] = trav_q.poll();
             //reached the end of a valid path from 0,0
             if(curr[0]==n-1 && curr[1]==n-1) return true;
             for(int d[]:dirs){
                 int di = curr[0]+d[0];
                 int dj = curr[1]+d[1];
                 if(isValidCell(matrix,di,dj) && !vis[di][dj] && matrix[di][dj]>=val){
                   vis[di][dj]=true;
                   trav_q.offer(new int[]{di,dj});
                 }
             }
         }
         return false;

     }
     public int maximumSafenessFactor(List<List<Integer>> grid) {
         //unintuitive by default
         //impossible to derive
         //initial idea was to use dfs, but turned out to be impossible :(
         //TC: O(n^2 * log(n))
         //SC: O(n^2)
         int n = grid.size();
         int mat[][]=new int[n][n];
         Queue<int[]>multi_src_bfs = new LinkedList<>();
         for(int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                 if(grid.get(i).get(j)==1){
                  multi_src_bfs.offer(new int[]{i,j});
                  mat[i][j]=0;
                 }else{
                    mat[i][j]=-1;
                 }  
             }
         }

         //msrc bfs
         while(!multi_src_bfs.isEmpty()){
             int size = multi_src_bfs.size();
             while(size-->0){
              int curr[] = multi_src_bfs.poll();
              int val = mat[curr[0]][curr[1]];
              for(int d[]:dirs){
                 int di = curr[0]+d[0];
                 int dj = curr[1]+d[1];
                 if(isValidCell(mat,di,dj) && mat[di][dj]==-1){
                   mat[di][dj]=val+1;
                   multi_src_bfs.offer(new int[]{di,dj});  
                 }
              }
             }
         }

         //binary search for finding the most appropriate val
         //from 0 to max_val in the matrix
         int l = 0;
         int r = 0;
         int res = -1;
         for(int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                  r = Math.max(r,mat[i][j]);
               }
          }

          //start bs
          while(l<=r){
             int mid = l+(r-l)/2;
             if(isValidPathBfs(mat,mid)){
                 //find the optimal val as mid 
                 //and thats ur ans, but try to find a bigger val
                 //so do move right with the l ptr
                 res=mid;
                 l=mid+1;   
             }else{
                 //else move left to find a smaller val that satifies
                 //the req moving the r ptr
                 r=mid-1;
             }
          }

         return res; 
     }
}