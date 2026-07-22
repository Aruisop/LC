class Solution {
     public void merge(int[] nums1, int m, int[] nums2, int n) {
         //TC: O(n*logn)
         //SC: O(1)
         for(int i=0;i<m+n;i++){
             if(i>=m){
              nums1[i]=nums2[i-m];
             }
         }
         Arrays.sort(nums1);
     }
}