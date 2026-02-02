class Solution {
     public int minEatingSpeed(int[] piles, int h) {
       int n = piles.length;
       int l = 1;
       int max = 0;
       for(int pile:piles){
        max = Math.max(max,pile);
       }
       int r = max;
       while(l<r){
         int m = l+(r-l)/2;
         int hours = 0;
         for(int x:piles) hours+=Math.ceil((double)x/m);
         if(hours<=h) r=m;
         else l=m+1;
         }
         return l;
     }
}