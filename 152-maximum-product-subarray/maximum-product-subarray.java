class Solution {
     public int maxProduct(int[] nums) {
         //TC: O(n)
         //SC: O(2*n) ~ O(n) (space un-optimised)
         int n = nums.length;
         int preprod[]=new int[n];
         int posprod[]=new int[n];
         int pp=1;
         int posp=1;
         //prefix prod
         for(int i=0;i<n;i++){
         pp = pp*nums[i];
         preprod[i] = pp;
         //reset pp if alr 0
         if(pp==0) pp=1;
         }
         for(int j=n-1;j>=0;j--){
            posp=posp*nums[j];
            posprod[j]=posp;
            if(posp==0) posp=1;
         }
         //trav thru and find max
         int max = Integer.MIN_VALUE;
         for(int i=0;i<n;i++){
           max = Math.max(max, Math.max(preprod[i], posprod[i]));
         }
         return max;    
     }
}