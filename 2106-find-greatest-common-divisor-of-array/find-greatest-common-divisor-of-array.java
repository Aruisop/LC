class Solution {
     private static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
     }
     public int findGCD(int[] nums) {
         //TC: O(n)
         //SC: O(1)    
         int min = Integer.MAX_VALUE;
         int max = Integer.MIN_VALUE;
         for(int ele:nums){
            min = Math.min(ele,min);
            max = Math.max(ele,max);
         }
         return gcd(min,max);
     }
}