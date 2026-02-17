class Solution {
     private static boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("*") || s.equals("/"); 
     }
     public int evalRPN(String[] tokens) {
         Stack<Integer>st=new Stack<>();
         for(String t:tokens){
                 if(!isOperator(t)) st.push(Integer.parseInt(t));
                 if(isOperator(t)){
                     //pop just 2 operands
                     int a = st.pop();
                     int b = st.pop();
                     if(t.equals("+")) st.push(b+a);
                     else if(t.equals("-")) st.push(b-a);
                     else if(t.equals("*")) st.push(b*a);
                     else if(t.equals("/")){
                        if(a==0) return 0;
                       st.push(b/a); 
                 }
          }
    }
 return st.peek();   
 }
}