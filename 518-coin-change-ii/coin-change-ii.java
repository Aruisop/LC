class Solution {
     private static int rec(int amount, int[] coins,int ind,int memo[][]){
       int n = coins.length;
       if(ind>=n) return 0;
       if(amount==0) return 1;
       if(memo[amount][ind]!=-1) return memo[amount][ind];
       int nottake = rec(amount,coins,ind+1,memo);
       int take=0;
       if(amount-coins[ind]>=0)
       take = rec(amount-coins[ind],coins,ind,memo);
       return memo[amount][ind]=nottake+take; 
     }
     public int change(int amount, int[] coins) {
      //rec+memo
      int n = coins.length;
      int memo[][]=new int[amount+1][n+1];
      for(int mem[]:memo)
      Arrays.fill(mem,-1);
      return rec(amount,coins,0,memo);
     }
}