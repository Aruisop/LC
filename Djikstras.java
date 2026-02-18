// TC: O((V+E)*log(V)), for my version its more like: O(ElogV) because of no dupli check for pq(line 19-20)
// SC: O(V+E) pq+dist-array
class Solution
{
    public  int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
       int ans [] = new int[V];
       int dist[]=new int[V];
       Arrays.fill(dist,Integer.MAX_VALUE);
       dist[S]=0;
       //can overflow for large integers
       //in that case use Integer.compare(a[1],b[1])
       PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->(a[1]-b[1]));
       pq.offer(new int[]{S,0});
       //no need of for loop here, confuses me every time..
       while(!pq.isEmpty()){
        int curr[] = pq.poll();
        int u = curr[0];
        // int uwt = curr[1];(only used for stale check in order to improve optimality)
        //works without the dupli check of  if uwt>dist[u] then continue (ignore the larger stale entry)
        //helps me find corr neighs of u
        for(ArrayList<Integer>ele:adj.get(u)){
               int v = ele.get(0);
               int vwt = ele.get(1);
               if(dist[v]>vwt+dist[u]){
                dist[v] = vwt+dist[u];
                pq.offer(new int[]{v,dist[v]});
               }
            }
        }
         for(int i=0;i<V;i++){
        ans[i]=dist[i];
       }
       return ans;
       }
}
