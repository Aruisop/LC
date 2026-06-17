class Solution {
     private static int rec(List<List<Integer>> triangle,int i, int j,Integer memo[][]){
         int n = triangle.size();
         if(i==n-1) return triangle.get(i).get(j);
         if(memo[i][j]!=null) return memo[i][j];
         int nextRowSameCol = rec(triangle,i+1,j,memo);
         int nextRowNextCol = rec(triangle,i+1,j+1,memo);
         return memo[i][j] = triangle.get(i).get(j) + Math.min(nextRowSameCol,nextRowNextCol);
     }
     public int minimumTotal(List<List<Integer>> triangle) {
       int m = triangle.size();
       //TC: O(n^2)
       //SC: O(n^2)
       // 1+2+3+4....n
       int n = triangle.get(0).size();
       Integer memo[][]=new Integer[m][m];
       return rec(triangle,0,0,memo);
     }
}