class Solution {
     public String decodeString(String s) {
      Stack<String>st= new Stack<>();
      String sb=new String();
      for(char ch:s.toCharArray()){
         if(ch == ']'){
         //build the str to repeat
         String repStr = new String(); 
          while(!st.peek().equals("[")){
            repStr = st.pop() + repStr;
          }
          st.pop();
          //find the number
          String number = new String();
          while(!st.isEmpty() && Character.isDigit(st.peek().charAt(0))){
            number = st.pop() + number;
          }
          int no = Integer.parseInt(number);
          //loop thru to repeat the strs
          StringBuilder consStr = new StringBuilder();
          for(int i=0;i<no;i++){
              consStr.append(repStr);
          }
          //push the consolidated str to the top of the stack
          st.push(consStr.toString());
         }
         if(ch!=']')
         st.push(String.valueOf(ch));
      }
      while(!st.isEmpty()){
        sb = st.pop() + sb;
      }
      return sb;   
     }
}