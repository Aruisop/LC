class Solution {
     public int scoreOfParentheses(String s) {
         int n = s.length();
         int depth = 0;
         int ans = 0;
         int i = 0;
         while(i<n){
             if(s.charAt(i)=='('){
             depth++;
             }else{
                 if(s.charAt(i-1)=='('){
                    depth-=1;
                    ans+=Math.pow(2,depth);
                 }else{
                    depth-=1;
                 }
             }
             i++;
         }
         return ans;
     }
}