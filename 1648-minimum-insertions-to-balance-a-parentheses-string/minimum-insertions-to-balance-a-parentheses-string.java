class Solution {
     public int minInsertions(String s) {
      int n = s.length();
      int i=0;
      int count = 0;
      int res=0;
      while(i<n){
         if(s.charAt(i)=='('){
            count++;
            i+=1;
         }else{
             if(count>0) count--;
             else res++;
             if(i+1<n && s.charAt(i+1)==')'){
               i+=2;
             }else{
                res++;
                i+=1;
             }
         }
      }
      return res+2*count;   
     }
}