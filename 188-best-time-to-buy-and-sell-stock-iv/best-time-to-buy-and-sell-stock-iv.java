class Solution {
     private static int rec(int memo[][][],int[] prices,int ind,int canBuy,int cap){
         int n = prices.length;
         if(ind==n || cap==0) return 0;
         if(memo[ind][canBuy][cap]!=-1) return memo[ind][canBuy][cap];
         int profit = 0;
         if(canBuy==1){
            int buy = -prices[ind] + rec(memo, prices, ind+1,0,cap);
            int skip = rec(memo, prices,ind+1,1,cap);
            profit = Math.max(buy,skip);
         }else{
            int sell = prices[ind] + rec(memo, prices, ind+1,1,cap-1);
            int hold = rec(memo,prices,ind+1,0,cap);
            profit = Math.max(sell, hold);
         }
         return memo[ind][canBuy][cap] = profit;
     }
     public int maxProfit(int k, int[] prices) {
         int n = prices.length;
         //same as best time to buy and sell stocks III, except with k instead of 2 as cap
         int memo[][][]=new int[n][2][k+1];
         for(int i=0;i<n;i++){
             for(int j=0;j<2;j++){
                Arrays.fill(memo[i][j],-1);
             }
         }
         return rec(memo,prices,0,1,k);
     }
}