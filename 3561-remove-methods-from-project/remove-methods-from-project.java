class Solution {
     public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
         List<List<Integer>>adj=new ArrayList<>();
         for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
         }
         int indegree[]=new int[n];
         for(int inv[]:invocations){
            adj.get(inv[0]).add(inv[1]);
            indegree[inv[1]]++;
         }
         Queue<Integer>q=new LinkedList<>();
         q.offer(k);
         boolean vis[]=new boolean[n];
         vis[k]=true;
         //bfs logic
         while(!q.isEmpty()){
             int u = q.poll();
             for(int v:adj.get(u)){
                 indegree[v]--; 
                 if(!vis[v]){
                  vis[v]=true;
                  q.offer(v);
                 }
             }
         }
         List<Integer>rem=new ArrayList<>();
         boolean remove_all_nodes = true;
         for(int i=0;i<n;i++){
             if(vis[i] && indegree[i]>0){
                remove_all_nodes = false;
                break;
             }else if(!vis[i]){
                rem.add(i);
             }
         }

         if(!remove_all_nodes){
             List<Integer>all = new ArrayList<>();
             for(int i=0;i<n;i++){
                all.add(i);
             }
             return all;
         }
         return rem;
     }
}