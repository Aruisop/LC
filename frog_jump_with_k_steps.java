// Brute-Force Approach
// TC: O(2^n)
// SC: O(n)

class Solution {
     public static int minm = Integer.MAX_VALUE;
     private static boolean isValidIndex(int[] heights, int i){
        int n = heights.length;
        return i>=0 && i<n;
     }
     private static void rec(int[] heights, int k,int i,int cost){
         int n = heights.length;
         if(i==n-1){
            minm = Math.min(minm,cost);
            return;
         }
         for(int j=i+1;j<=i+k;j++){
             if(isValidIndex(heights,j)){
               int newcost = Math.abs(heights[i]-heights[j]);
               rec(heights,k,j,cost+newcost);
             }
         }
     }
     public int frogJump(int[] heights, int k) {
        minm = Integer.MAX_VALUE;
        rec(heights,k,0,0);
        return minm;
     }
}

// Optimised on recursion, with memoisation, change in approach tho
// TC: O(n)
// SC: O(n)

class Solution {
     //shift towards the int memo soln  
     private static boolean isValidIndex(int[] heights,int i){
         int n = heights.length;
         return (i>=0 && i<n);
     }
     private static int recmem(int[] heights, int k,int i,int memo[]){
         int n = heights.length;
       if(i==n-1) return 0;
       if(memo[i]!=-1) return memo[i];
         int ans = Integer.MAX_VALUE, cost = 0;
       for(int j=i+1;j<=i+k;j++){
         if(isValidIndex(heights,j)){
          cost = Math.abs(heights[i]-heights[j])+recmem(heights,k,j,memo);
          ans = Math.min(ans,cost);
          }
         }
         return memo[i]=ans;
     }
     public int frogJump(int[] heights, int k) {
        int n = heights.length; 
       int memo[] = new int[n]; 
       Arrays.fill(memo,-1);
       return recmem(heights,k,0, memo);
     }
}
