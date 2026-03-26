// User function Template for Java
class Solution {
     private static boolean dfs(int node, int parent, boolean vis[], int m, int n,ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;
        for(int neigh:adj.get(node)){
            if(!vis[neigh]){
                if(!dfs(neigh,node,vis,m,n,adj)) return false;
            }else if(parent!=neigh){
                return false;
            } 
        }
        return true;
     }
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        // code here
        //the overall struc of the q was amb
        //assumed edges to be the adj list 
        //need to create it
        //BForce DFS, Optimised is using DSU, will try that
        // this shld work tho
        //TC: O(m+n), trav thru edegs as well as nodes
        //SC: O(n)--->rec stack space
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(ArrayList<Integer>edge:edges){
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        //invalidate first and then validate
        boolean vis[]=new boolean[n];
        if(m!=n-1) return false;
        if(!dfs(0,-1,vis,m,n,adj)) return false;
        for(boolean v:vis) if(!v) return false;
        return true;
    }
}
