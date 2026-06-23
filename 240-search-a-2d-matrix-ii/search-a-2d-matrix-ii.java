class Solution {
     private static boolean bs(int row[],int lo, int hi, int target){
         if(row.length==1 && target==row[0]) return true;
         while(lo<=hi){
           int mid = lo+(hi-lo)/2;
           if(row[mid]==target) return true;
           if(row[mid]<target) lo=mid+1;
           if(row[mid]>target) hi=mid-1;
         }
         return false;
     }
     public boolean searchMatrix(int[][] matrix, int target) {
         //TC: O(m*logn)
         //SC: O(1)
         int m = matrix.length;
         int n = matrix[0].length;
         for(int i=0;i<m;i++){
            if(bs(matrix[i],0,n-1,target)) return true;   
         }
         return false;  
     }
}