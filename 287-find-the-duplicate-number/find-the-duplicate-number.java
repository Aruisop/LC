class Solution {
     public int findDuplicate(int[] nums) {
         //brute force is with two ptrs:
         /*
         //TC: O(n^2), SC : O(1)
         class Solution {
         public int findDuplicate(int[] nums) {
         //tle 2ptrs appraoch smh
         int l=0;
         int n = nums.length;
         int r=l+1;
         while(r<n){
         if(nums[l]!=nums[r]) r++;
         if(r<n && nums[l]==nums[r]) return nums[l];
         if(r==n-1){
             if(n!=2){
               l++;
               r=l+1;
              }
             }
         }
         return -1;
         }
         }
         */
         //only other soln is slow+fast ptr logic
         //unintuit af, would go with above approach as at least it solves the problem
         //with the requirements of not using extra space

         //TC:O(n)
         //SC:O(1)
         //modelled like a linked list
         //as 1..n integers and n+1 nos with exactly 1 no rep
         //Floyds Cycle Detection for ll :(  
         int slow = nums[0];
         int fast = nums[nums[0]];
         while(slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
         }
         //reset slow to the st/head of the ll(imagine)
         //and then move both the slow and fast ptr one at a time till they meet
         //and that is your ans
         slow=0;
         while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
         }
         return slow;
     }
}