class Solution {
     private static int MOD  = 1_000_000_007;
     public int maxSum(List<Integer> nums, int k) {
             //TC: O(n)
             //SC: O(32)  
             int count[]=new int[32];
             long res = 0;
             //create the count arr
             for(int ele:nums){
                 for(int i=0;i<32;i++){
                   if( ((1<<i) & ele ) !=0) count[i]++;
                 }
             }
             //iterate backwards from k
             while(k-->0){
                 long curr = 0;
              for(int i=0;i<32;i++){
                 if(count[i]>0){
                     //set the bit
                     curr = (curr | (1<<i))%MOD;
                     count[i]--;
                 }
              }
               res=(res + (curr*curr))%MOD;
             }
         return (int)res%MOD;
      }
}