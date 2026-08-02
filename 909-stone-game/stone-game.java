class Solution {
     //base-level recursion follows : LC 486
     private static int rec(int l, int r, int piles[],int memo[][]){
        if(l==r) return memo[l][r] = piles[l];
        if(memo[l][r]!=-1) return memo[l][r];
        return memo[l][r] = Math.max( piles[l]-rec(l+1,r,piles,memo) , piles[r]-rec(l,r-1,piles,memo) );
     } 
     public boolean stoneGame(int[] piles) {
         //Slightly Optimised, Memoised
         //{core idea: recurse based on finding the difference btw p1 and p2 scores}
         //TC: O(n^2)
         //SC: O(n)  
         int n = piles.length;
         int memo[][]=new int[n][n];
         for(int mem[]:memo){
            Arrays.fill(mem,-1);
         }
         return rec(0,n-1,piles,memo)>=0;
     }
}