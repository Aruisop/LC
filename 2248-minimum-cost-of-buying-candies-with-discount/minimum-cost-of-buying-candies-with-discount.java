class Solution {
     public int minimumCost(int[] cost) {
         //  [1,2,3]  
         //  [2,2,5,6,7,9]
         //   0,1,2,3,4,5
         //  [1,2,3,4]
         //TC: O(nlogn)
         //SC: O(1)
         Arrays.sort(cost);
         int n = cost.length;
         int sum = 0;
         int k = 0;
         int r = n-1;
         //2, 3, 4, 5, 5, 10, 10, 10
         //   r         
         if(n==1) return cost[0];
         if(n==2) return cost[0]+cost[1];
         if(n==3) return cost[2]+cost[1];
        //  if(n==4) return cost[0]+cost[2]+cost[3];
        while(r>=0){
             if(r-1>=0){ 
             sum+=cost[r-1]+cost[r];
             r-=2;
             }else if(r-1<0){
                 // 0th index case for odd indexed arr
                 // ie a even len array
                 sum+=cost[r];
             }
             r--;
         }
         return sum;     
   }
}