class Solution {
     private static int ctDigs(int n){
         int ct_digs = 0;
         int temp = n;
         while(temp!=0){
            temp/=10;
            ct_digs++;
         }
         return ct_digs; 
     } 
     public int countCommas(int n) {
         //bruforce
         //TC:O(n*n)
         //SC: O(1)
         int count = 0;
         for(int i=1;i<=n;i++){
          int ct = ctDigs(i);
          if(ct<4) continue;
          else count++;
         }   
         return count;
     } 
}