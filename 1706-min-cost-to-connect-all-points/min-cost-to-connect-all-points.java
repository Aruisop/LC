class Solution {
     public int minCostConnectPoints(int[][] points) {
         //Prims optimal algo(non-inutuit; revise Algo)
         // TC: O(n^2)
         // SC: O(n^2)
         int n = points.length;
         int minDist[]=new int[n];
         Arrays.fill(minDist,Integer.MAX_VALUE);
         minDist[0]=0;
         boolean vis[]=new boolean[n];
         int calcCost=0; 
         for(int i=0;i<n;i++){
             int u =-1;
             //find proper u, with minm dist
             for(int j=0;j<n;j++){
                 if(!vis[j] && (u==-1 || minDist[j]<minDist[u])){
                    u=j;
                 }
             }
             vis[u]=true;
             calcCost+=minDist[u];
             //build up the minm dist array
             for(int v=0;v<n;v++){
                 if(!vis[v]){
                    int currDist = Math.abs(points[u][0]-points[v][0])+Math.abs(points[u][1]-points[v][1]);
                    minDist[v] = Math.min(currDist,minDist[v]); 
                 }
             }
         }
         return calcCost;   
     }
}