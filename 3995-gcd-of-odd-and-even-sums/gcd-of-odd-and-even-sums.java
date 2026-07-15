class Solution {
     private static int gcd(int a, int b){
      if(b==0) return a;  
      return gcd(b, a%b);
     }
     public int gcdOfOddEvenSums(int n) {
             //TC: O(n)
             //SC: O(log(n)) {rec stack}    
             int oddsum = 0;
             int evesum = 0;
             int oct = 1;
             int ect = 1;
             int onum = 1;
             int e_num  = 2;
             while(oct<=n){ 
               oddsum +=onum; 
               onum = onum+2;
               oct++;
             }
             while(ect<=n){ 
               evesum +=e_num; 
               e_num = e_num+2;
               ect++;
             }
             return gcd(oddsum,evesum);
     } 
}