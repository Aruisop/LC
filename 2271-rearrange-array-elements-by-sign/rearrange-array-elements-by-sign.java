class Solution {
     public int[] rearrangeArray(int[] nums) {
         int s1 = 0;
         int s2 = 0;
         int n = nums.length;
         int ans[]=new int[n];
         int k = 0;
         int prev = 0;
         while(s1<n && s2<n){
          while(nums[s1]<0 && prev<=0) s1++;
          if(nums[s1]>0 && prev<=0){
             ans[k++]=nums[s1];
             prev=nums[s1];
             s1++;
             }
             while(nums[s2]>0 && prev>=0) s2++;
             if(nums[s2]<0 && prev>=0){
             ans[k++]=nums[s2];
              prev=nums[s2];
              s2++;
             }
             
         }
         return ans;
     }
}