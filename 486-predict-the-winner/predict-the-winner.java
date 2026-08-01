class Solution {
     private static int rec(int l, int r,int nums[]){
         if(l==r) return nums[l];
         //at each stage, a pt gained for one player is a point lost for the other
         //so rather than finding the cost at the end for each player
         //find the difference between player1 and player2 scores 
         return Math.max(nums[l]-rec(l+1,r,nums),nums[r]-rec(l,r-1,nums)); 
     } 
     public boolean predictTheWinner(int[] nums) {
         //Brute-force solution
         //TC: O(2^n)
         //SC: O(n)   
         int n=nums.length;
         return rec(0,n-1,nums)>=0;
     }
}