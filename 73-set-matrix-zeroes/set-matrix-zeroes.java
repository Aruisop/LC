class Solution {
     public void setZeroes(int[][] matrix) {
         //2 pass approach(brute force)
         //TC: O(m*n)
         //SC: O(m+n)
         int m = matrix.length;
         int n = matrix[0].length;
         boolean row[]=new boolean[m];
         boolean col[]=new boolean[n];
         for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
              if(matrix[i][j]==0){
                row[i]=true;
                col[j]=true;
              }
             }
         }
         //2nd pass
         for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
             if(row[i] || col[j]){
                //make as 0
                matrix[i][j]=0;
             }
             }
         }
     }
}