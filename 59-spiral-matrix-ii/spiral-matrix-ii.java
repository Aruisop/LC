class Solution {
     public int[][] generateMatrix(int n) {
         //TC: O(n^2)
         //SC: O(n^2){return matrix}
         int matrix[][]=new int[n][n];
         if(n==0) return matrix;
         int rowstart = 0;
         int colstart = 0;
         int rowend = n-1;
         int colend = n-1;
         int num = 1;
         while(rowstart<=rowend && colstart<=colend){
             for(int j=colstart;j<=colend;j++){
                matrix[rowstart][j]=num++;
             }
             rowstart++;
             for(int i=rowstart;i<=rowend;i++){
               matrix[i][colend]=num++;
             }
             colend--;
              for(int j=colend;j>=colstart;j--){
               matrix[rowend][j]=num++;
             }
             rowend--; 
             for(int i=rowend;i>=rowstart;i--){
                matrix[i][colstart]=num++;
             }
             colstart++;
         }
         return matrix;
     }
}