class Solution {
     public int singleNumber(int[] nums) {
         //TC: O(n)
         //SC: O(1)
         //simple idea: 0 xored with anything is the number itself
         int xor = 0;
         for(int ele:nums){
          xor^=ele;
         }
         return xor;    
     }
}