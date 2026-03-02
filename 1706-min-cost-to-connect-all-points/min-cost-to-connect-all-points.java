class DSU{
     int parent[];
     int rank[];
     DSU(int n){
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
            rank[px]++;
         }
         return true;
     } 
 }
class Solution {
     public int minCostConnectPoints(int[][] points) {
      //BFORCE DSU+Kruskals, main bottleneck over here is sorting edges 
      //TC: O(N^2*log(N^2))  ~ O(E*log(E)) ~ O(2*N^2*log(N)) ~ O(N^2*log(N))
      //SC: O(N^2) (list building using the edges)
      //Optimization here is using Prim's Algo 
      List<int[]> e = new ArrayList<>();
      int n = points.length;
      for(int i=0;i<n;i++){
         for(int j=i+1;j<n;j++){
           int mDist = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
           e.add(new int[]{mDist,i,j});
         }
      }
      Collections.sort(e,(a,b)->(a[0]-b[0]));
      DSU dsu = new DSU(n);
      int collectedCost = 0;
      int usedEdges = 0;
      for(int edge[]:e){
         int cost = edge[0];
         int u = edge[1];
         int v = edge[2];
         //ensure that union works, ie u and v are not alr conn
         //basically not part of the same comp
         if(dsu.union(u,v)){
            //take the cost and connect u and v
           collectedCost+=cost; 
           usedEdges++;
         }
         //has only n-1 edges
         if(usedEdges==n-1) break;
      }
      return collectedCost;     
     }
}