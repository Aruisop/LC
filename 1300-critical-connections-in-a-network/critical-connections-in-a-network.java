class Solution {
     static int time=0;
     private static void dfs(int node, int parent, boolean vis[], int disc[], int low[],List<List<Integer>>adj,List<List<Integer>>ans){
         vis[node]=true;
         disc[node]=low[node]=++time;
         for(int neigh:adj.get(node)){
           if(neigh==parent) continue;
           //run a dfs for the neigh as the src node and the curr node as the parent
           if(!vis[neigh]){
           dfs(neigh,node,vis,disc,low,adj,ans);
           //after the dfs has been done for that node, check if the low[node]
           //can have a smaller value in comparison to the low[neigh]
           low[node]=Math.min(low[node],low[neigh]);
           //check if removing the edge btw the node and neigh leads to disconnecn, in that case 
           //there is a bridge
           if(low[neigh]>disc[node]) ans.add(Arrays.asList(node,neigh));
           }else{
            //backedge serves as an escape route :(
            low[node]=Math.min(low[node],disc[neigh]);
           }
         }
     }
     public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
      //finding the number of bridges in the graph
      //This happens via Tarjans Algo :(
      //very unintuitive
      //TC: O(V+E)
      //SC: O(V+E)
      List<List<Integer>>adj = new ArrayList<>();
      List<List<Integer>>ans = new ArrayList<>();
      for(int i=0;i<n;i++) adj.add(new ArrayList<>());
      for(List<Integer>conn:connections){
        int u = conn.get(0);
        int v = conn.get(1);
        adj.get(u).add(v);
        adj.get(v).add(u);
      }
      //dfs for each node
      int disc[]=new int[n];
      boolean vis[]=new boolean[n];
      int low[]=new int[n];
      //parent needs to be traced
      for(int i=0;i<n;i++){
        if(!vis[i]) dfs(i,-1,vis,disc,low,adj,ans);
      }
      return ans;
     }
}