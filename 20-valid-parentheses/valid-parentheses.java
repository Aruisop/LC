class Solution {
     public boolean isValid(String s) {
         Stack<Character>st=new Stack<>();
         if(s.length()==1) return false;
         for(char ch:s.toCharArray()){
             if(ch == '(' || ch == '{' || ch=='['){
              st.push(ch);
             }else{
                 if(st.isEmpty()) return false;
                 char top = st.peek();
                 if( (top=='{' && ch=='}') || (top=='(' && ch==')') || (top=='[' && ch==']') )   {
                   st.pop();
                  continue;
                 }else{
                    return false;
                 }
             } 
         }
         return st.isEmpty();     
     }
}