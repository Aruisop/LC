class Solution {
     private static StringBuilder getRle(StringBuilder prev){
         int n = prev.length();
         StringBuilder rleseq = new StringBuilder();
         int i = 0;
         while(i<n){
             int ct = 1;
             while(i+1<n && prev.charAt(i)==prev.charAt(i+1)){
              ct++;
              i++;
             }
             rleseq.append(ct).append(prev.charAt(i));
             i++; 
         }
         return rleseq;
     }
     private static StringBuilder recHelp(int n){
             //TC: O(len str, nth final val)
             //SC: O(len str, nth final val)+O(n)->{rec-stack}
             if(n==1) return new StringBuilder("1");
             StringBuilder prev = new StringBuilder();
             if(n>1) prev = recHelp(n-1);
             return getRle(prev);
     }
     public String countAndSay(int n) {
         return recHelp(n).toString();
     }
}