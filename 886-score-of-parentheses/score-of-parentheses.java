class Solution {
     public int scoreOfParentheses(String s) {
         int ans = 0;
         int n = s.length();
         Stack<Integer>st=new Stack<>();
         for(int i=0;i<n;i++){
             if(s.charAt(i)=='('){
               st.push(ans);
               ans=0; 
             }else{
                 if(s.charAt(i-1)=='('){
                     ans = st.peek()+1;
                  }else{
                    ans=st.peek()+2*ans;
                  }
                  st.pop();
             }
         }
         return ans;   
     }
}