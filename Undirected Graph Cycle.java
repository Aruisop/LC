// ############ BFS APPROACH ############
//TC: O(V+E) 
//SC: O(V+E)  
class Solution {
    private static boolean bfs(int i,List<List<Integer>>adj,boolean vis[]){
         Queue<int[]>q=new LinkedList<>();
         q.offer(new int[]{i,-1});
         vis[i]=true;
         while(!q.isEmpty()){
          int curr[]=q.poll();
          int c = curr[0];
          int p = curr[1];
          for(int neigh:adj.get(c)){
            if(!vis[neigh]){
                    vis[neigh]=true;
                    q.offer(new int[]{neigh,c});
                }else if(neigh!=p) return true;  
            }
        }
          return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int ed[]:edges){
            int u = ed[0];
            int v = ed[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(bfs(i,adj,vis)) return true;
            }
        }
        return false;
    }
}

// ############ DFS APPROACH ############
//TC: O(V+E) 
//SC: O(V+E) 
class Solution {
    private static boolean dfs(int curr, int parent, boolean vis[], List<List<Integer>>adj){
     vis[curr]=true;
     for(int neigh:adj.get(curr)){
         if(!vis[neigh]){
             if(dfs(neigh,curr,vis,adj)) return true;
         }else if(neigh!=parent){
             return true;
         }
     }
      return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int ed[]:edges){
            int u = ed[0];
            int v = ed[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(i,-1,vis,adj)) return true;
            }
        }
        return false;
    }
}
  
