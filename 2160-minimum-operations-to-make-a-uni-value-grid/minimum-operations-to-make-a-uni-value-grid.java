class Solution {
     public int minOperations(int[][] grid, int x) {
         //TC: O(m*n)
         //SC: O(m*n)
         int m = grid.length;
         int n = grid[0].length;
         List<Integer>tmp=new ArrayList<>();
         for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
           tmp.add(grid[i][j]);
          }
         }
         //sort and ensure that the median is clearly found
         Collections.sort(tmp);
         //find median over here
         int median = tmp.get(tmp.size()/2);
         int ct = 0;
         for(int i=0;i<tmp.size();i++){
            if(Math.abs(tmp.get(i)-median)%x!=0) return -1;
            ct+=Math.abs(tmp.get(i)-median)/x;
         }
         return ct;
     }
}