class Solution {
     public int minimumDeletions(int[] nums) {
         //TC: O(n)
         //SC: O(1)
         //Unintuit  
         int min= Integer.MAX_VALUE;
         int max= Integer.MIN_VALUE;
         int maxIndex = -1;
         int minIndex = -1;
         int n = nums.length;
         for(int i=0;i<n;i++){
             if(nums[i]<min){
              min = nums[i];
              minIndex = i;
             }
             if(nums[i]>max){
                max = nums[i];
                maxIndex = i;
             }
         }
         int l = Math.min(minIndex,maxIndex);
         int r = Math.max(minIndex,maxIndex);
         int all_from_front = r+1;
         int all_from_back = n-l;
         int some_from_front_some_from_back = l+1+n-r;
         return Math.min(all_from_front,Math.min(all_from_back,some_from_front_some_from_back));
     }
}