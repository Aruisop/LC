class Solution {
     private static int dfs(int i, int j, int memo[][], int m, int n,int[][] matrix){
        if(memo[i][j]!=-1) return memo[i][j];
        int maxLen = 1;
        if(i+1<m && matrix[i+1][j]>matrix[i][j]) maxLen = Math.max(maxLen, 1+dfs(i+1,j,memo,m,n,matrix));
        if(i-1>=0 && matrix[i-1][j]>matrix[i][j]) maxLen = Math.max(maxLen, 1+dfs(i-1,j,memo,m,n,matrix));
        if(j+1<n && matrix[i][j+1]>matrix[i][j]) maxLen = Math.max(maxLen, 1+dfs(i,j+1,memo,m,n,matrix));
        if(j-1>=0 && matrix[i][j-1]>matrix[i][j]) maxLen = Math.max(maxLen, 1+dfs(i,j-1,memo,m,n,matrix));
        return memo[i][j]=maxLen;
     }
     public int longestIncreasingPath(int[][] matrix) {
       //TC: O(m*n*4) 4 for the dirs
       //SC: O(m*n) 
       int m = matrix.length;
       int n = matrix[0].length;
       int maxLen = 0;
       int memo[][]=new int[m][n];
       for(int mem[]:memo) Arrays.fill(mem,-1);
       for(int i=0;i<m;i++){
         for(int j=0;j<n;j++){
           maxLen = Math.max(maxLen, dfs(i,j,memo,m,n, matrix));
         }
       }
       return maxLen;      
     }
}