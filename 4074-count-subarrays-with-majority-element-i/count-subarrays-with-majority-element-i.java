class Solution {
     public int countMajoritySubarrays(int[] nums, int target) {
         //BForce TC: O(n^2)
         //SC: O(1)
         int n = nums.length;
         int ans = 0;
         for(int i=0;i<n;i++){
             int targ_ct = 0;
             for(int j=i;j<n;j++){
                 if(nums[j]==target){
                        targ_ct++;
                  }
                 int size = j-i+1;
                 if(targ_ct>size/2) ans++;
                 }
         }
         return ans;   
     }
}