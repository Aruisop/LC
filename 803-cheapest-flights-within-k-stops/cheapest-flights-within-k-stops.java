class Solution {
     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
     List<List<List<Integer>>>adj=new ArrayList<>();
     for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
     }    
     for(int f[]:flights){
        int u = f[0];
        int v = f[1];
        int wt = f[2];
        adj.get(u).add(Arrays.asList(v,wt));
     }
     PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
     pq.offer(new int[]{src,0,0});
     //the second dimension tracks the number of edges used; 
     //we minimise(cost(nodes,stops/edgesused))
     //the maxm no of edges we can use for k stops is k+1 edges
     //from 0 to k+1 there are k+1-0+1(k+2) values
     //rest all is same as Djik
     int dist[][]=new int[n][k+2];
     for(int d[]:dist){
        Arrays.fill(d,Integer.MAX_VALUE);
     }
     dist[src][0]=0;
     while(!pq.isEmpty()){
         int curr[]=pq.poll();
         int u = curr[0];
         int cost = curr[1];
         int stops = curr[2];
         if(u==dst) return cost;
         //invalid
         if(stops>k) continue;
         for(List<Integer>neigh:adj.get(u)){
             int v = neigh.get(0);
             int wt = neigh.get(1);
             if(dist[v][stops+1]>cost+wt){
                dist[v][stops+1]=cost+wt;
                pq.offer(new int[]{v,cost+wt,stops+1});
             }
         }   
     }
     return -1;
     }
}