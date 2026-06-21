class Solution {
     public int maxIceCream(int[] costs, int coins) {
         //Without counting sort
         //TC: O(nlogn)
         //SC: O(1)
         int min = Integer.MAX_VALUE;
         for(int ele:costs){
           min =  Math.min(min,ele);
         }
         if(coins<min) return 0;
         Arrays.sort(costs);

          //[1,1,2,3,4]
          //[1,2,4,7,11]

          //[1,1,2,3,5,6]
          //[1,2,4,7,12,18]

          //[2,3,3,6,6,6,7,9,10] 
          //[2,5,8,14,20,26,32,39,48,58] 
          int n = costs.length;
          long presum = 0; 
          long ct=0;
         for(int i=0;i<n;i++){
             presum+=costs[i];
             if(presum<=coins){
                ct++;
             }
         }
          return (int)ct;
     }
}