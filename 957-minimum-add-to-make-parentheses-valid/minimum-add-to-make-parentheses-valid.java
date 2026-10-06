class Solution {
     public int minAddToMakeValid(String s) {
         Stack<Character>st=new Stack<>();
         int openct = 0;
          for(char ch:s.toCharArray()){
             if(ch=='(') st.push(ch);
             else if(!st.isEmpty() && st.peek()=='(' && ch==')'){ 
               st.pop();
              }else if((st.isEmpty() && ch==')') || (openct>0)){
                 openct++;
                 st.push(ch);
              } 
         }
         return st.size();      
     }
}