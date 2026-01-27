class Solution {
     public int largestAltitude(int[] gain) {
          int n = gain.length;
          int pre=0;
          int max = Integer.MIN_VALUE;
          for(int i=0;i<n+1;i++){
             max=Math.max(max,pre);
             if(i<n) pre+=gain[i];
           }
           return max;
     }
}