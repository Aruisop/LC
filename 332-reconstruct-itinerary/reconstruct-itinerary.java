class Solution {
     private static void dfs(String start,Map<String, PriorityQueue<String>>graph,List<String>ans){
         PriorityQueue<String>pq=graph.get(start);
         while(pq!=null && !pq.isEmpty()){
            dfs(pq.poll(),graph,ans);
         }
         ans.add(start);
     }
     public List<String> findItinerary(List<List<String>> tickets) {
         //use a map adj list not std List<List>
         //the idea is to create the complex adjlist and then do dfs  
         //TC: O(nlogn)
         //SC: O(n)
         Map<String, PriorityQueue<String>>graph = new HashMap<>();
         List<String>ans = new ArrayList<>();
         for(List<String>ticket:tickets){
            graph.computeIfAbsent(ticket.get(0), k->new PriorityQueue<>()).offer(ticket.get(1));
         }
         dfs("JFK",graph,ans);
         Collections.reverse(ans);
         return ans;
     }   
}