class DSU{
     int parent[];
     int rank[];
     int size[];
     int n;
     DSU(int n){
     this.n=n;
     parent = new int[n];
     rank = new int[n];
     size = new int[n];
     for(int i=0;i<n;i++){
      parent[i] = i;
      rank[i] = 0;
      size[i] = 1;
     }
     }
     //find
     int find(int x){
        if(parent[x]!=x) parent[x]=find(parent[x]);
        return parent[x];
     }
     //union,  size changes based on the parent
     void union(int x,int y){
         int px=find(x);
         int py=find(y);
         if(px==py) return;
         if(rank[px]<rank[py]){
          parent[px]=py;
          size[py]+=size[px];  
         }else if(rank[py]<rank[px]){
          parent[py]=px;
          size[px]+=size[py]; 
         }else{ 
         parent[py]=px;
         size[px]+=size[py];  
          }
         }
}
class Solution {
     public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU dsu = new DSU(n*n);
        int dirs[][]={{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                     //row major indexing
                     int node1 = i*n+j;
                     for(int d[]:dirs){
                         int ni = i+d[0];
                         int nj = j+d[1];
                         if(ni>=0 && ni<n && nj>=0 && nj<n && grid[ni][nj]==1){
                            int node2=ni*n+nj;
                            dsu.union(node1,node2);
                         }
                     }
                }
             }
         }
         //find the maxsize of isl
         int maxislsize = 0;
         for(int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                 //hashset logic for marking parent is imp
                 HashSet<Integer>hs=new HashSet<>();
                 int size = 1;
                 if(grid[i][j]==0){
                     for(int d[]:dirs){
                         int ni = i+d[0];
                         int nj = j+d[1];
                         //ensure that the neigh to the 0 grid is a 1, to find the maxm
                         if(ni>=0 && ni<n && nj>=0 && nj<n && grid[ni][nj]==1){
                             int parent = dsu.find(ni*n+nj);
                             if(!hs.contains(parent)){
                                hs.add(parent);
                                size+=dsu.size[parent];
                             }
                         }
                     }
                 }
                 maxislsize = Math.max(maxislsize,size); 
             }
         }

         //case if only 1s are present
         for(int i=0;i<n*n;i++){
             if(dsu.parent[i]==i){
              maxislsize = Math.max(maxislsize,dsu.size[i]);
             }
         }
         return maxislsize;
     }
}