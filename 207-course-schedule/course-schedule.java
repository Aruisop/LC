class Solution {
     public boolean canFinish(int numCourses, int[][] prerequisites) {
     //imp concept is to count the processed nodes and compare with the total number of nodes
     //TC: O(V+E)
     //SC: O(V+E)
     List<List<Integer>>adj=new ArrayList<>();
     for(int i=0;i<numCourses;i++){
        adj.add(new ArrayList<>());
     }
     int indeg[]=new int[numCourses];  
     for(int pr[]:prerequisites){
        int u = pr[0];
        int v = pr[1];
        adj.get(v).add(u);
        indeg[u]++;
     }
     Queue<Integer>q=new LinkedList<>();
     for(int i=0;i<numCourses;i++){
        if(indeg[i]==0)q.offer(i);
     }
     int ct=0;
      while(!q.isEmpty()){
         int node = q.poll();
         ct++;
         for(int neigh:adj.get(node)){
             indeg[neigh]--;
             if(indeg[neigh]==0) q.offer(neigh);
         }
      }
      return ct==numCourses;
     }
}