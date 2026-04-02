class Solution {
     public int calculate(String s) {
        //TC: O(n)+O(1){char processing via stack} ~ O(n)
        //SC: O(n)
        //unintuit 
      int n = s.length();
      Stack<Integer>st=new Stack<>();
      int res = 0;
      int num = 0;
      int sign = 1;
      for(int i=0;i<n;i++){
             char ch = s.charAt(i);
          if(Character.isDigit(ch)) num = num*10+(ch-'0');
          else if(ch=='+'){
             res+=sign*num;
             num = 0;
             sign = 1;
          }else if(ch=='-'){
             res+=sign*num;
             num = 0;
             sign = -1;
          }else if(ch=='('){
             //store the res and the sign
             st.push(res);
             st.push(sign);
             //reset the res and the sign
             res = 0;
             sign = 1;
          }else if(ch==')'){
             //accumulate the final res inside the bracket, and proceed
             //and reset
             res=res+sign*num;
             num = 0;
             //re-get the values of sign and the prev res outside "()"
             res*=st.pop();
             res+=st.pop();
             }
          }
         //cant return res as is, as we need to consider the case 
         //in which the last ele is a no, and isnt added
         //therefore add that signed no
         return res + sign*num;   
     }
}