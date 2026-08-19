class Solution {
     private static double rec(double x,long N){
         if(N==0) return 1;
         double res = 0;
         double half=rec(x,N/2);
          if(N%2==0) res=half*half;
          else{
          res=half*half*x;
          }
          return res;
     }
     public double myPow(double x, int n) {
         //TC: O(logn)
         //SC: O(logn)
        long N = n;
        if(N<0) return 1/rec(x,-N);
        return rec(x,N);
     }
}