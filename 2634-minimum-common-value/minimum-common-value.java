class Solution {
     public int getCommon(int[] nums1, int[] nums2) {
         int m = nums1.length;
         int n = nums2.length;
         HashSet<Integer>hs = new HashSet<>();
         for(int i=0;i<m;i++){
            hs.add(nums1[i]);
         }
         int min = Integer.MAX_VALUE;
         // 1,2,3
         for(int j=0;j<n;j++){
          if(hs.contains(nums2[j])){
            //potential cand
            min = Math.min(min, nums2[j]);
          }
         }
         return min==Integer.MAX_VALUE?-1:min; 
     }
}