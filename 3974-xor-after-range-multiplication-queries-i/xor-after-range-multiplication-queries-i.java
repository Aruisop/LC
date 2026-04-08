class Solution {
     public int xorAfterQueries(int[] nums, int[][] queries) {
         //Bforce is prolly the cleanest approach
         //TC: O(k*n) where k is len of queries ~  O(n^2)
         //SC: O(1) 
         int mod = 1_000_000_007;
         for(int query[]:queries){
             int li = query[0];
             int ri  = query[1];
             int ki = query[2];
             int vi = query[3];
             int idx = li;
             while(idx<=ri){
                nums[idx]=(int)((long)nums[idx]*vi%mod);
                idx+=ki;
             }
         }
         int xor = 0;
         for(int ele:nums){
            xor = xor^ele;
         }
         return xor;
     }
}