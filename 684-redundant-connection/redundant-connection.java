 class DSU{
     int parent[];
     int rank[];
     int n;
     DSU(int n){
         this.n=n;
         parent=new int[n];
         rank=new int[n];
         for(int i=0;i<n;i++){
           parent[i]=i;
           rank[i]=0;
         }
     }
     int find(int x){
        if(parent[x]!=x) parent[x]=find(parent[x]);
        return parent[x];
     }
     boolean union(int x, int y){
         int px = find(x);
         int py = find(y);
         if(px==py) return false;
         if(rank[px]<rank[py]){
            parent[px]=py;
         }else if(rank[py]<rank[px]){
            parent[py]=px;
         }else{
            parent[py]=px;
         }
        return true;
     }
 }
 class Solution {
     public int[] findRedundantConnection(int[][] edges) {
         //initially naively initialised DSU with n*n, it should be n(space optimised)
         int n = edges.length;
         DSU dsu = new DSU(n+1);
         for(int edge[]:edges){
            int node1 =  edge[0];
            int node2 = edge[1];
            if(!dsu.union(node1,node2)) return new int[]{node1,node2};
         }
         return new int[]{};
     }
 } 