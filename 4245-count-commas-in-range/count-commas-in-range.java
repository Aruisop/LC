class Solution {
     public int countCommas(int n) {
         //slight optimisation
         //TC:O(n)
         //SC: O(1)
         int temp = n;
         int ct_digs = 0;
         while(temp!=0){
            temp/=10;
            ct_digs++;
         }
         if(ct_digs<4) return 0;
         int count = 0;
         for(int i=n;i>=1000;i--){
               count++;
         }   
         return count;
     } 
}