class Solution {
     public int longestValidParentheses(String s) {
         //TC: O(n)
         //SC: O(1)
         int n = s.length();
         int openct = 0, closect = 0;
         int ans = 0;
         //left-right scan
         for(char ch:s.toCharArray()){
             if(ch=='(') openct++;
             else if(ch==')') closect++;
             if(closect>openct){
                openct = 0;
                closect = 0;
             }else if(closect==openct){
                ans = Math.max(ans,openct+closect);
             }
         }
         
         openct =0;
         closect =0;
         //right-left scan
         for(int i=n-1;i>=0;i--){
             if(s.charAt(i)==')') closect++;
             else if(s.charAt(i)=='(') openct++;
             if(openct>closect){
                openct = 0;
                closect = 0;
             }else if(closect==openct){
                ans = Math.max(ans,openct+closect);
             }
         }

         return ans;
     }
}