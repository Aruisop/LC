class Solution {
     public int findPeakElement(int[] nums) {
         int n = nums.length;
         //if only 1 ele, the first ele is peak
         if(n==1) return 0;
          //check for 0 and n-1;
         // as -1th and nth ele are both -inf
         if(nums[0]>nums[1]) return 0;
         if(nums[n-1]>nums[n-2]) return n-1;
         int l = 1;
         int r = n-1;
         //the peak ele can lie either as the mid ele directly, or
         // if it lies on the incr curve, there will be a peak on the right
         // if it lies on the decr curve, a peak lies to the left   
         while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) return mid;
            else if(nums[mid]>nums[mid-1]) l=mid+1;
            else r=mid-1;
         }
         return -1;
     }
}