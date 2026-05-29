class Solution {
     public boolean search(int[] nums, int target) {
         //TC: O(logN)
         //SC: O(1)
         //Approach 2
         int n = nums.length;
         int l = 0;
         int r = n-1;
         while(l<=r){
             int mid = l+(r-l)/2;
             if(nums[mid]==target) return true;
             //nums[l]<nums[mid] not <= as in type 1 of this problem
             if(nums[l]==nums[mid] && nums[mid]==nums[r]){
                 //solve problem based on ambiguous case  
                 l++;
                 r--;
             }else if(nums[l]<=nums[mid]){
                 //lhs sorted first
                 if(nums[l]<=target && target<nums[mid]) r=mid-1;
                 else l=mid+1;
             }else{
                 //rhs sorted first
                 if(nums[mid]<target && target<=nums[r]) l=mid+1;
                 else r=mid-1;
             }
         }
         return false;
     }
}