class Solution {
     private static void dfs(String email,HashSet<String> vis,List<String>component,Map<String,Set<String>>graph){
         vis.add(email);
         component.add(email);
         for(String nei:graph.get(email)){
           if(!vis.contains(nei)) dfs(nei,vis,component,graph);
         }
     }
     public List<List<String>> accountsMerge(List<List<String>> accounts) {
      Map<String,Set<String>>graph=new HashMap<>();
      //to store the visited emails
      HashSet<String> vis = new HashSet<>();
      //to store the name
      HashMap<String,String>emailToName=new HashMap<>(); 
      for(List<String>ac:accounts){
         String name = ac.get(0);
         for(int i=1;i<ac.size();i++){
         String email = ac.get(i);
         emailToName.put(email,name);
         graph.putIfAbsent(email,new HashSet<>());
         if(i>1){
            String prev = ac.get(i-1);
            graph.get(prev).add(email);
            graph.get(email).add(prev);
               }
              }
             }
             //dfs logic
             List<List<String>>ans=new ArrayList<>();
             for(String email:graph.keySet()){
               List<String>component = new ArrayList<>();
               if(!vis.contains(email)){
               dfs(email,vis,component,graph);
               Collections.sort(component);
               component.add(0,emailToName.get(email));
               ans.add(component);
              }
             }
            return ans;   
     }
}