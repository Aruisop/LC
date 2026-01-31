class Solution {
     private static int rec(int[] prices,int ind,int canBuy,int memo[][]){
        int n = prices.length;
       if(ind>=n) return 0;
       if(memo[ind][canBuy]!=-1) return memo[ind][canBuy];
       int profit=0;
       if(canBuy==1){
         int buy = -prices[ind]+rec(prices,ind+1,0,memo);
         int skip = rec(prices,ind+1,1,memo);
         profit = Math.max(buy, skip);
         }else{
          int sell =  prices[ind]+rec(prices,ind+2,1,memo);
          int hold = rec(prices,ind+1,0,memo);
          profit = Math.max(sell, hold);      
         }
         return memo[ind][canBuy]=profit;
     }
     public int maxProfit(int[] prices) {
         //same logic as that of stocksII except we move to index+2 rather than index+1 while selling
         //this is to acc for the cooldown period
         int n = prices.length;
         int memo[][]=new int[n][2];
         for(int i=0;i<n;i++){
            memo[i][0]=-1;
            memo[i][1]=-1;
         }
         return rec(prices,0,1,memo);
     }
}