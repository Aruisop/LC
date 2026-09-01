class Solution {
     private static int findReachables(List<List<Integer>>adj,       List<List<Integer>>adj_new,int src,int n,int distanceThreshold){
         int dist[]=new int[n];
         Arrays.fill(dist,Integer.MAX_VALUE);
         dist[src]=0;
         PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->(a[0]-b[0]));
         pq.offer(new int[]{0,src});
         while(!pq.isEmpty()){
             int poll[]=pq.poll();
             int d = poll[0];
             int vertex = poll[1];
             if(d>dist[vertex]) continue;
             for(int i=0;i<adj.get(vertex).size();i++){
              int neigh = adj.get(vertex).get(i);
              int wt = adj_new.get(vertex).get(i);
              int new_wt = wt+d;
              if(new_wt<dist[neigh] && new_wt<=distanceThreshold){
                dist[neigh] = new_wt;
                pq.offer(new int[]{new_wt,neigh});
              }
             }
         }
         int reachables = 0;
         for(int i=0;i<n;i++){
            if(i!=src && dist[i]<=distanceThreshold) reachables++;
         }
         return reachables;
     }
     public int findTheCity(int n, int[][] edges, int distanceThreshold) {
         List<List<Integer>>adj=new ArrayList<>();
         for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
         }
         //  Map<List<Integer>,Integer>mp=new HashMap<>();
         List<List<Integer>>adj_new=new ArrayList<>();
          for(int i=0;i<n;i++){
            adj_new.add(new ArrayList<>());
         }
         for(int e[]:edges){
             int u = e[0];
             int v = e[1];
             int w = e[2];
             //  mp.put(new ArrayList<>(Arrays.asList(u,v)),w);
             //  mp.put(new ArrayList<>(Arrays.asList(v,u)),w);
             adj.get(u).add(v);
             adj.get(v).add(u);
             adj_new.get(u).add(w);
             adj_new.get(v).add(w);
         }
         System.out.println(adj);
         System.out.println(adj_new);
         //  System.out.println(mp);
         //imagine: i==u then v{list}==adj.get(i)
         int ans = -1;
         int minReachable = Integer.MAX_VALUE;
         for(int i=0;i<n;i++){
             int reachable = findReachables(adj,adj_new,i,n,distanceThreshold);
             if(reachable<=minReachable){
               minReachable = reachable;
               ans = i;
             }  
         }
         return ans;
     }
}