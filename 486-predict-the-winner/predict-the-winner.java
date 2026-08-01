class Solution {
     private static int rec(int l, int r,int nums[],int memo[][]){
         if(l==r) return memo[l][r] = nums[l];
         //missed this previously, so it was effectively moving evaluating using recursion :|
         if(memo[l][r]!=-1) return memo[l][r];
         //at each stage, a pt gained for one player is a point lost for the other
         //so rather than finding the cost at the end for each player
         //find the difference between player1 and player2 scores
         return memo[l][r]=Math.max(nums[l]-rec(l+1,r,nums,memo),nums[r]-rec(l,r-1,nums,memo)); 
     } 
     public boolean predictTheWinner(int[] nums) {
         //Memoised solution
         //TC: O(n^2)
         //SC: O(n)   
         int n=nums.length;
         int memo[][]=new int[n][n];
         for(int mem[]:memo){
            Arrays.fill(mem,-1);
         }
         return rec(0,n-1,nums,memo)>=0;
     }
}