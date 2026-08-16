class Solution {
     public boolean stoneGameIX(int[] stones) {
         //TC: O(n)
         //SC: O(1)
         //Unintuitive, need to know what to do exactly.  
         int count[]=new int[3];
         for(int ele:stones){
            count[(ele%3)]++;
         }
         if(count[0]%2==0){
          return (count[1]>0 && count[2]>0);
         }
         return Math.abs(count[1]-count[2])>2;
     }
}