class Solution {
     private static int atMost(int[] nums, int k){
         int oddct = 0;
         int l=0;
         int ct = 0;
         int n = nums.length;
         for(int r=0;r<n;r++){
             if(nums[r]%2!=0)oddct++;
             while(oddct>k){
                if(nums[l]%2!=0)oddct--;
                l++;
             } 
              ct+=(r-l+1);
         }
         return ct;  
     }
     public int numberOfSubarrays(int[] nums, int k) {
      //use logic of atmost ie (<=k) - (<=k-1)
      // [<=5] - [<=4]  (1,2,3,4,5)-(1,2,3,4) ====> (5) remains exactly which is k
      return atMost(nums,k) - atMost(nums,k-1);      
     }
}