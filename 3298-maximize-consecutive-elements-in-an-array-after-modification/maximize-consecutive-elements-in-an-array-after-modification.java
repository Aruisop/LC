class Solution {
     int n;
     static int memo[][];
     private static int findLowerBound(int start, int nums[], int target){
         //find first index that is nums[lo]>= target
         int n = nums.length;
         int lo  = start, hi = n;
         while(lo<hi){
             int mid = lo+(hi-lo)/2;
             if(nums[mid]<target) lo=mid+1;
             else hi=mid;
         }
         if(lo<n && nums[lo]==target) return lo;
         return -1;
     }
     private static int solve(int nums[],int inc,int i){
         int n = nums.length;
         if(i>=n) return 0;
         if(memo[i][inc]!=-1) return memo[i][inc];
         int currval = nums[i]+inc;
         int len = 1;
         //option i find currval+1 and inc 0
         int j = findLowerBound(i+1,nums,currval+1);
         if(j!=-1){
            len = Math.max(len,1+solve(nums,0,j));
         }
         //option ii find currval and inc 1
         j = findLowerBound(i+1,nums,currval);
         if(j!=-1){
            len = Math.max(len,1+solve(nums,1,j));
         }
         return memo[i][inc]=len;
     }
     public int maxSelectedElements(int[] nums) {
          n= nums.length;
          int res = 1;
          Arrays.sort(nums);
          memo=new int[n+1][2];
          for(int r[]:memo) Arrays.fill(r,-1);
          for(int i=0;i<n;i++){
             res= Math.max(Math.max(solve(nums,0,i),solve(nums,1,i)),res);
          }
          return res;  
     }
}