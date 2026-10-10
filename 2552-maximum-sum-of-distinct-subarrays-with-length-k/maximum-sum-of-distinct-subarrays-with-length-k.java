class Solution {
     public long maximumSubarraySum(int[] nums, int k) {
         int n = nums.length;
         int l = 0;
         int r = 0;
         long sum =0;
         long max = 0; 
         Set<Integer>set = new HashSet<>();
          while(r<n){
             while(set.contains(nums[r])){
                sum-=nums[l];
                set.remove(nums[l]);
                l++;
             }
             sum+=nums[r];
             set.add(nums[r]);
             if(r-l+1==k){
                max = Math.max(sum,max);
                sum-=nums[l];
                set.remove(nums[l]);
                l+=1;
             }
             r++;
         }
         return max;   
     }
}