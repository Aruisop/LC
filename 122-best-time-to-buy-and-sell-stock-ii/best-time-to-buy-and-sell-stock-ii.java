class Solution {
     private static int rec(int memo[][],int prices[],int ind,int canBuy){
         int n = prices.length;
         if(ind==n) return 0;
         if(memo[ind][canBuy]!=-1) return memo[ind][canBuy];
         int profit=0;
         if(canBuy==1){
           int buy = -prices[ind] + rec(memo,prices,ind+1,0);
           int skip = rec(memo,prices,ind+1,1);
           profit=Math.max(buy,skip);
         }else{ 
            //sell condn
            int sell = prices[ind] + rec(memo,prices,ind+1,1);
            int hold = rec(memo,prices,ind+1,0);
            profit = Math.max(sell,hold);
         }
         return memo[ind][canBuy]=profit;
     }
     public int maxProfit(int[] prices) {
         int n = prices.length;
         int memo[][]=new int[n][2];
         for(int i=0;i<n;i++){
         memo[i][0]=-1;
         memo[i][1]=-1;
         }
         return rec(memo,prices,0,1);
     }
}