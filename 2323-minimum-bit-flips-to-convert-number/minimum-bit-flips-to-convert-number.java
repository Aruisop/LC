class Solution {
     public int minBitFlips(int start, int goal) {
             //Main idea is to xor the start and goal } why? because we need to find the places where the bits differ 1^0=1
             //0^0=1 and 1^1=0
             //in the number, for this we xor start and goal, find which posns differ (ie 1)
             //and then proceed to count the number of set bits in the xor value 
             //TC: O(n)
             //SC: O(1)    
             int xor = start^goal;
             int temp = xor;
             int ct = 0;
             //Brian Kerninghan's trick, can use a built in method for counting number of set bits asw
             while(temp!=0){
              temp = temp&(temp-1);
              ct++;  
             }
             return ct;
     }
}