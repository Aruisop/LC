class Solution {
     private static int rec(int nums[],int ind,int memo[]){
         int n = nums.length;
         if(ind>=n-1) return 0;
         if(memo[ind]!=-1) return memo[ind];
         int min = Integer.MAX_VALUE;
         int maxJump = nums[ind];
         for(int j=1;j<=maxJump;j++){
            if(j+ind<n && rec(nums,j+ind,memo)!=Integer.MAX_VALUE)
           min = Math.min(min,1+rec(nums,j+ind,memo));
         }
         return memo[ind]=min;
     }
     public int jump(int[] nums) {
        //memoised soln
      int n = nums.length;
      int memo[]=new int[n+1];
      Arrays.fill(memo,-1);
      return rec(nums,0,memo);   
     }
}