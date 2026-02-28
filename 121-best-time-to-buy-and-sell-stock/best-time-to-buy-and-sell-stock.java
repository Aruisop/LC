class Solution {
     public int maxProfit(int[] prices) {
         //one way to do it is via rec+memo but thats overkill when
         //TC: O(n) is simplified  
         //SC: O(1)
         int profit =0;
         int n = prices.length;
         int maxprofit=Integer.MIN_VALUE; 
         int minprice=Integer.MAX_VALUE;
         for(int i=0;i<n;i++){
          minprice = Math.min(minprice, prices[i]);
          maxprofit = Math.max(maxprofit, prices[i]-minprice);
         } 
         return maxprofit;
     }
}