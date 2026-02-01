class Solution {
     public int[] productExceptSelf(int[] nums) {
         int n = nums.length;
         int res[]=new int[n];
         int lres[]=new int[n];
         int rres[]=new int[n];
         Arrays.fill(lres,1);
         Arrays.fill(rres,1);
         int left = 1;
         for(int i=0;i<n;i++){
           lres[i]=lres[i]*left;
           left=left*nums[i];
         }
         int right = 1;
         for(int i=n-1;i>=0;i--){
           rres[i]=rres[i]*right;
           right=right*nums[i];
         }
         for(int i=0;i<n;i++){
            res[i] = lres[i] * rres[i];
         }
         return res;   
     }
}