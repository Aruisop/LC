class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
     //way more intuitive solution in comparison to prev solns
     //Used Djiktras
     //TC: O(E*logV) E as we iterate thru edges once and then V is due to pq (heap)
     //SC: O(V+E) adj list constr 
     List<List<int[]>>adj=new ArrayList<>();
     for(int i=0;i<=n;i++){
        adj.add(new ArrayList<>());
     }   
     for(int time[]:times){
        int u = time[0];
        int v = time[1];
        int w = time[2];
        adj.get(u).add(new int[]{v,w});
     }
     int dist[]=new int[n+1];
     Arrays.fill(dist,Integer.MAX_VALUE);
      dist[k]=0;
     PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->(a[0]-b[0]));
     pq.offer(new int[]{0,k});
     while(!pq.isEmpty()){
         int curr[]=pq.poll();
         int time = curr[0];
         int node = curr[1];
         for(int neigh[]:adj.get(node)){
             int neighv = neigh[0];
             int neightime = neigh[1];
             //Djikstras algo default
             if(time+neightime<dist[neighv]){
              dist[neighv] = time+neightime;
              pq.offer(new int[]{dist[neighv],neighv});
             } 
         }
     }
     //find the maxm, the trick over here is the idea abt the fact that 
     //the signal must be delivered to every node, and thus we take the maxm available time
     //minm not on a global basis
     //Djikstras algo gives the shortest time from the src node to the destn node
     //once thats sorted, we just need to find the largest such time, because only at that time
     //the signal from k will reach all the other vertices
     int max = Integer.MIN_VALUE;
     for(int i=1;i<=n;i++){
        if(dist[i]==Integer.MAX_VALUE) return -1;
        max = Math.max(max,dist[i]);
     }
     return max;
    }
}