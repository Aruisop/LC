class Solution {
     private static boolean rec(String s, String p,int i,int j,Boolean memo[][]){
         int m = s.length();
         int n = p.length();
         //ensure that the pattern runs out first, not vice versa
         if(j==n){
           if(i==m) return true;
           return false;
         }
         if(memo[i][j]!=null) return memo[i][j];
         boolean ans = false;
         boolean first_char_matched = (i<m) && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
         //check the 1st index char in the pattern,(0th char cant be *)
         if((j+1)<n && p.charAt(j+1)=='*'){
            //skip the char in the pattern
           boolean not_take = rec(s,p,i,j+2,memo);
           //take the char and match to pattern in the text, j remains same here, as multiple
           //occurences of the preceding char can be matched in the pattern to the text
           boolean take = first_char_matched && rec(s,p,i+1,j,memo);
           ans = not_take || take;
         }else{
            //if the 1st index char in the pattern is not a *
            //ensure that the first chars match for the text and pattern and rec check for 
            //i+1 and j+1 posns
            ans = first_char_matched && rec(s,p,i+1,j+1,memo);
         }
         return memo[i][j]=ans;
     }
     public boolean isMatch(String s, String p) {
         //rec memo
         int m = s.length();
         int n = p.length();
         Boolean memo[][]=new Boolean[m+1][n+1];
          return rec(s,p,0,0,memo);
     }
}