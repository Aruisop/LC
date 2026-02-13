class Solution {
     private static int rec(int ind,int cost[],int memo[]){
        int n = cost.length;
        if(ind>=n) return 0;
        if(memo[ind]!=-1) return memo[ind];
        return memo[ind]=cost[ind]+Math.min(rec(ind+1,cost,memo),rec(ind+2,cost,memo));
     }
     public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int memo[]=new int[n+1];
        Arrays.fill(memo,-1);
        return Math.min(rec(0,cost,memo),rec(1,cost,memo));
     } 
}