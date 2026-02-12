class Solution {
     public String removeOuterParentheses(String s) {
         //O(1) sc solution
         //d marks the depth, mimics the stack in const space
         int d=0;
         StringBuilder sb = new StringBuilder();
         for(char c:s.toCharArray()){
             if(c=='('){
                 if(d>0){
                   sb.append(c);
                  }
                 d++;   
             }else{
                d--;
                if(d>0){
                sb.append(c);
                }
             }
          }
          return sb.toString();    
     }
}