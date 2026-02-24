class Solution {
     public void rotate(int[][] matrix) {
             int n = matrix.length;
             int k = 0;
             int temp=0;
             //transpose the mat
             for(int i=0;i<n;i++){
              for(int j=i;j<n;j++){
                   temp = matrix[i][j];
                  matrix[i][j] = matrix[j][i];
                  matrix[j][i] = temp;
              }
             }

              //reverse each row 
             for(int i=0;i<n;i++){
                 for(int j=0;j<n/2;j++){
                     temp=matrix[i][j];
                     matrix[i][j]=matrix[i][n-j-1];
                     matrix[i][n-j-1]=temp;
                 }
             }
     }
}