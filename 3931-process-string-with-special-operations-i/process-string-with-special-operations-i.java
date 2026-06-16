class Solution {
     public String processStr(String s) {
          //TC: O(n)
          //SC: O(n) ~includes the returning str res over here
         StringBuilder res = new StringBuilder();
         for(char ch:s.toCharArray()){
                if(Character.isLowerCase(ch)){
                 res.append(ch);
                 }else{
                 //only move to this block if res isnt empty  
                 if(ch=='*' && !res.isEmpty()){
                  res.deleteCharAt(res.length()-1);
                 }
                 if(ch=='#' && !res.isEmpty()){
                  res.append(res);
                 }
                 if(ch=='%' && !res.isEmpty()){
                    res.reverse();
                  }
                 }
 
             }
         return res.toString();
     } 
}