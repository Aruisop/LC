class Solution {
     private static int rec(int[] prices,int memo[][][],int ind,int canBuy,int cap){
         int n = prices.length;
         if(ind==n || cap==0) return 0;
         int profit = 0;
         if(memo[ind][canBuy][cap]!=-1) return memo[ind][canBuy][cap];
         if(canBuy==1){
            int buy = -prices[ind]+rec(prices,memo,ind+1,0,cap);
            int skip = rec(prices,memo,ind+1,1,cap);
            profit = Math.max(buy,skip);
         }else{
            int sell = prices[ind]+rec(prices,memo,ind+1,1,cap-1);
            int hold = rec(prices,memo,ind+1,0,cap);
            profit = Math.max(sell,hold);
         }
         return memo[ind][canBuy][cap]=profit;
     }
     public int maxProfit(int[] prices) {
          int n = prices.length;
          //3d dp as even cap is changing now
          //cap has 3 values ie 0,1,2
          int memo[][][]=new int[n][2][3];
          for(int i=0;i<n;i++){
             for(int j=0;j<2;j++){
                Arrays.fill(memo[i][j],-1);
             }
          }
          return rec(prices,memo,0,1,2);
     }
}