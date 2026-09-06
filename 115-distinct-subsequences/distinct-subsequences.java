class Solution {
     private static int rec(int index,String s, String t,int memo[][],StringBuilder sb){
         int m = s.length();
         int n = t.length();
         int matched = sb.length();
         if(matched==n) return 1;
         if(index>=m) return 0;
         if(memo[index][matched]!=-1) return memo[index][matched];
         int pick = 0;
         //only choose the character that matches in s.
         //t's chars are chosen via the matched index; ie the next char to be matched in t is matched with the curr char in s
         if(s.charAt(index)==t.charAt(matched)){
          sb.append(s.charAt(index));
          pick = rec(index+1,s,t,memo,sb);
          //backtrack
          sb.deleteCharAt(sb.length()-1);
         }
         int leave = rec(index+1,s,t,memo,sb);
         return memo[index][matched]=pick+leave;
     }
     public int numDistinct(String s, String t) {
         //TC:O(m*n)
         //SC:O(m*n)
        int m = s.length();
        int n = t.length();
        int memo[][]=new int[m][n];
        for(int mem[]:memo){
        Arrays.fill(mem,-1);    
        }
        return rec(0,s,t,memo,new StringBuilder());
     }
}