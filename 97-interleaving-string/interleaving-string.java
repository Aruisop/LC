class Solution {
     private static boolean rec(int i, int j, String s1, String s2, String s3, Boolean memo[][]){
        int n1 = s1.length();
        int n2 = s2.length();
        if(i==n1 && j==n2) return true;
        if(memo[i][j]!=null) return memo[i][j];
        boolean ans = false;
        int k = i+j;
        if(i<n1 && s1.charAt(i)==s3.charAt(k)) ans = ans || rec(i+1,j,s1,s2,s3,memo);
        if(j<n2 && s2.charAt(j)==s3.charAt(k)) ans = ans || rec(i,j+1,s1,s2,s3,memo);
        return memo[i][j]=ans;
     }
     public boolean isInterleave(String s1, String s2, String s3) {
      //Space-Optimized Rec Memo   
      //TC: O(n1*n2)
      //SC: O(n1*n2)  
      int n1 = s1.length();
      int n2 = s2.length();  
      int n3 = s3.length();
      if(n1+n2!=n3) return false;
      Boolean memo[][]=new Boolean[n1+1][n2+1];
      return rec(0,0,s1,s2,s3,memo); 
     }
}