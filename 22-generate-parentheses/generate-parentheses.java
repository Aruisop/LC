class Solution {
     private static void rec(List<String> al,StringBuilder sb, int open, int close, int n){
         if(sb.length() == 2*n){
            al.add(sb.toString());
            return;
         }
         if(open<n){
            sb.append("(");
            rec(al,sb,open+1,close,n);
            sb.deleteCharAt(sb.length()-1);
         }
         if(close<open){
            sb.append(")");
            rec(al,sb,open,close+1,n);
            sb.deleteCharAt(sb.length()-1);
         }
     }
     public List<String> generateParenthesis(int n) {
        List<String> al = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        rec(al,sb,0,0,n);  
        return al; 
     }
}