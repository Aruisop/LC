class Solution {
     private static int expand(String s,int l,int r){
         int ct=0;
         int n = s.length();
         //ct the no of palindromes from that center
         while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
            ct++;
            l--;
            r++;
         }
          return ct;
     }
     public int countSubstrings(String s) {
         int n = s.length();
         int ct=0;
         for(int i=0;i<n;i++){
            //ct for all odd len palind strs
            ct+=expand(s,i,i);
            //ct for all even len palind strs
            ct+=expand(s,i,i+1);
          }
          return ct;   
     }
}