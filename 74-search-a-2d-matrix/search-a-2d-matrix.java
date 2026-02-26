class Solution {
     public boolean searchMatrix(int[][] matrix, int target) {
           //BruteForce 
           // TC: O(M*N) to create the list & then bs
           //  SC: O(2*(M*N))
          int m = matrix.length;
          int n = matrix[0].length;
          int l=0;
          int r=m*n-1;
          List<Integer>al=new ArrayList<>();
          for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                 al.add(matrix[i][j]);
             }
          }
          int arr[]=new int[al.size()];
          int k=0;
          for(int i=0;i<arr.length;i++){
            arr[k++]=al.get(i);
          }
          //do bs on this arr
          while(l<=r){
           int mid = l+(r-l)/2;
           if(arr[mid]==target) return true;
           else if(arr[mid]<target) l= mid+1;
           else r=mid-1;            
          }
          return false;
     }
}