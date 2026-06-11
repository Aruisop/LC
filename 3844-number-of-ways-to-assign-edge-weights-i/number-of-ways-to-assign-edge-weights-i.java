class Solution {
     private static long power(long x, long y, long m){
        if(y==0) return 1;
        long p = power(x,y/2,m);
        p = (p*p)%m;
        return (y%2==0)?p:(x*p)%m;
     }
     private static void dfs(int u,List<List<Integer>>adj,boolean vis[],int depth[]){
        vis[u]=true;
        for(int v:adj.get(u)){
             if(!vis[v]){
             depth[v]=depth[u]+1;
             vis[v]=true;
             dfs(v,adj,vis,depth);
             }
        }
     }
     public int assignEdgeWeights(int[][] edges) {
          //TC: O(n)
          //SC: O(n)  
          long mod = 1000_000_007;
          List<List<Integer>>adj=new ArrayList<>();
          int n = edges.length+1;
         for(int i=0;i<=n;i++){
           adj.add(new ArrayList<>());
          }
          for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
          }
          int depth[]=new int[n+1];
          boolean vis[]=new boolean[n+1];
          depth[1]=0;
          //dfs for maxdepth
          dfs(1,adj,vis,depth);
          int maxdepth = Integer.MIN_VALUE;
          for(int i=1;i<=n;i++){
            maxdepth = Math.max(maxdepth,depth[i]);
          }
          //bin exponentiation for finding large powers
          return (int)power(2,maxdepth-1,mod);   
     }
}