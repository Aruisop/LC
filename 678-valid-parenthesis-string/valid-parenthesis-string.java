class Solution {
     public boolean checkValidString(String s) {
         //TC: O(n)
         //SC: O(1)
         int n = s.length();
         int openct =0, closect=0;
         for(char ch:s.toCharArray()){
             //greedily assume that * is ( in the forward pass
             if(ch=='(' || ch=='*') openct++;
             else if(ch==')') closect++;
             if(closect>openct) return false; 
         }
         openct = 0;
         closect = 0;
         for(int i=n-1;i>=0;i--){
             //and greedily assume that * is ) in the backward pass
             if(s.charAt(i)==')'|| s.charAt(i)=='*') closect++;
             else if(s.charAt(i)=='(') openct++;
             if(openct>closect) return false;  
         }
        return true;    
     }
}