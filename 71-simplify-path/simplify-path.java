class Solution {
     public String simplifyPath(String path) {
         //TC: O(n)
         //SC: O(n)
         String parts[] = path.split("/");
         Stack<String>st=new Stack<>();
         StringBuilder ans = new StringBuilder();
         for(String part:parts){
             if(part.equals(".") || part.equals("")) continue;
             else if(part.equals("..")){
              if(!st.isEmpty()) st.pop();
             }else{
                //valid dir name, push to stack
                st.push(part);
             }
         }
         if(st.isEmpty()) return new String("/");
         for(String s:st){
          ans.append("/");
          ans.append(s);
         }
         return ans.toString();           
     }
}