class Solution {
     private static int rec(int nums[],int ind,int prevind,int memo[][]){
        int n = nums.length;
        if(ind==n) return 0;
        if(memo[ind][prevind+1]!=-1) return memo[ind][prevind+1];
        //if no prev ele exists, take it or in the case that it does
        //ensure that the prev ele is smaller
        int take = 0;
        int leave = rec(nums,ind+1,prevind,memo);
        if(prevind==-1 || nums[prevind]<nums[ind]) take = 1+rec(nums,ind+1,ind,memo);
        return memo[ind][prevind+1]=Math.max(take,leave);
     }
     public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int memo[][]=new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(memo[i],-1);
        }
        return rec(nums,0,-1,memo);
     }
}