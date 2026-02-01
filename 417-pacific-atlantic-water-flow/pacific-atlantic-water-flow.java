class Solution {
     private static void dfs(int i,int j,boolean vis[][],int[][] heights, int prevht){
      int m = heights.length;
      int n = heights[0].length;
      if(i<0 || i>=m || j<0 || j>=n ||vis[i][j] || heights[i][j]<prevht) return;
      vis[i][j] = true;
      prevht = heights[i][j];
      dfs(i+1,j,vis,heights,prevht);
      dfs(i,j+1,vis,heights,prevht); 
      dfs(i-1,j,vis,heights,prevht);
      dfs(i,j-1,vis,heights,prevht);
     }
     public List<List<Integer>> pacificAtlantic(int[][] heights) {
         List<List<Integer>>ans=new ArrayList<>();
         int m = heights.length;
         int n = heights[0].length;
         //start dfs from the oceans inwards, dfs more intuitive in comp to bfs
         boolean pacific[][]=new boolean[m][n];
         boolean atlantic[][]=new boolean[m][n];
        
         //idea is to start from the boundaries
        
         //Pacific
         for(int i=0;i<m;i++){
          dfs(i,0,pacific,heights,-1);
         }
         for(int j=0;j<n;j++){
          dfs(0,j,pacific,heights,-1);
         }
         
         //Atlantic
         for(int i=0;i<m;i++){
           dfs(i,n-1,atlantic,heights,-1);
         }
         for(int j=0;j<n;j++){
            dfs(m-1,j,atlantic,heights,-1);
         }

         //add those indices which satisfy both dfs for pacific and atlantic
         for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]) ans.add(Arrays.asList(i,j));
             }
         }
         return ans;
     }
}