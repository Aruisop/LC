class Solution {
     public boolean searchMatrix(int[][] matrix, int target) {
      //Optimal BS solution
      //TC: O(log(m*n))
      //SC: O(1)
      int m = matrix.length;
      int n = matrix[0].length;
      int l=0;
      int r=m*n-1;
      while(l<=r){
         int mid = l+(r-l)/2;
         //get the posn in the matrix, this is imp
         //smtg that just works
         int row = mid/n;
         int col = mid%n;
         if(matrix[row][col]==target) return true;
         else if(matrix[row][col]<target) l=mid+1;
         else r=mid-1;   
      }
      return false;
     } 
}