class Solution {
     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //Better version ong
        // TC: O(E*k)
        //SC: O(V+E)
     List<List<int[]>>adj=new ArrayList<>();
     int dist[]=new int[n];
     Arrays.fill(dist,Integer.MAX_VALUE);
     for(int i=0;i<n;i++) adj.add(new ArrayList<>());
     for(int f[]:flights){
        int u = f[0];
        int v = f[1];
        int wt = f[2];
        adj.get(u).add(new int[]{v,wt});
     }
     Queue<int[]>q=new LinkedList<>();
     dist[src] = 0;
     q.offer(new int[]{src,0});
     int lvl = 0;
     while(!q.isEmpty() && lvl<=k){
         int qsize = q.size();
         for(int i=0;i<qsize;i++){
             int curr[]=q.poll();
             int u = curr[0];
             int d = curr[1];
             for(int[]nei:adj.get(u)){
                 int v = nei[0];
                 int vwt = nei[1];
                 if(d+vwt<dist[v]){
                    dist[v]=d+vwt;
                    q.offer(new int[]{v,d+vwt});
                 }
             }
          }
         lvl++;
         }
         if(dist[dst]==Integer.MAX_VALUE) return -1;
         return dist[dst];   
     }
}