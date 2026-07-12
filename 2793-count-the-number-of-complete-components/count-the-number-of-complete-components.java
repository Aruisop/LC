class Solution {
     private static void dfs(List<List<Integer>>adj,boolean vis[],int start_vertex,List<Integer>comp){
         vis[start_vertex]=true;
         comp.add(start_vertex);
         for(int neigh:adj.get(start_vertex)){
             if(!vis[neigh]){
             dfs(adj,vis,neigh,comp);
             }
         }
     }
     public int countCompleteComponents(int n, int[][] edges) {
         List<List<Integer>>adj = new ArrayList<>();
         for(int i=0;i<n;i++){
           adj.add(new ArrayList<>());
         }
         for(int e[]:edges){
             int u = e[0];
             int v = e[1];
             adj.get(u).add(v);
             adj.get(v).add(u);
         }
         boolean vis[]=new boolean[n];
         int comps = 0;
         for(int i=0;i<n;i++){
             if(!vis[i]){
                 boolean flag = true;
                 List<Integer>comp = new ArrayList<>();
                 dfs(adj,vis,i,comp);
                 for(int u:comp){
                     if(adj.get(u).size()!=comp.size()-1){
                         flag = false;
                         break;
                     }
                 }
                 if(flag) comps++;
             }
         }
         return comps;      
     }
}