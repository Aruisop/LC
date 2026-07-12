class Solution {
     public int countCompleteComponents(int n, int[][] edges) {
         List<List<Integer>>adj = new ArrayList<>();
         for(int i=0;i<n;i++) adj.add(new ArrayList<>());
         for(int i=0;i<n;i++) adj.get(i).add(i);
         for(int e[]:edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);           
         }
         Map<List<Integer>,Integer>hm = new HashMap<>();
         for(int i=0;i<n;i++){
             List<Integer>al = adj.get(i);
             Collections.sort(al);
             hm.put(al,hm.getOrDefault(al,0)+1);  
         }
         int complete_comp = 0;
         //for a compl component of k vertices, k neighs should be present  
         for(Map.Entry<List<Integer>,Integer>entry:hm.entrySet()){
           if(entry.getKey().size()==entry.getValue())complete_comp++;  
         }
         return complete_comp;    
     }
}