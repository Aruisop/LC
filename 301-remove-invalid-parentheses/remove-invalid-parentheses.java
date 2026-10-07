class Solution {
     private static void rec(String s,List<String>ans,StringBuilder sb,int i,int count){
         int n = s.length();
         if(count<0) return;
         if(i==n){
            if(count==0) ans.add(sb.toString());
            return;
         }
            //take case
             if(s.charAt(i)=='('){
                 sb.append(s.charAt(i));
                 rec(s,ans,sb,i+1,count+1);
                 sb.deleteCharAt(sb.length()-1);
             }else if(s.charAt(i)==')'){
                 sb.append(s.charAt(i));
                 rec(s,ans,sb,i+1,count-1);
                 sb.deleteCharAt(sb.length()-1);
             }else{
                 //just a so recurse thru a
                 sb.append(s.charAt(i));
                 rec(s,ans,sb,i+1,count);
                 sb.deleteCharAt(sb.length()-1);
             }
         //leave case
         if(s.charAt(i)=='(' || s.charAt(i)==')')rec(s,ans,sb,i+1,count);
     }
     public List<String> removeInvalidParentheses(String s) {
         List<String>ans=new ArrayList<>();
         rec(s,ans,new StringBuilder(),0,0);
         Set<String>finAns=new HashSet<>();
         //minm number of removals is maximum length valid paranthesis strings
         int maxLen = 0;
         for(String trav_s:ans){
          maxLen = Math.max(maxLen,trav_s.length()); 
         }
         for(String trav_s:ans){
          if(maxLen == trav_s.length()) finAns.add(trav_s);   
         }
         return new ArrayList<>(finAns);    
     }
}