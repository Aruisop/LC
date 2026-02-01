class Solution {
     private static int rec(int i,int j, int memo[][],String text1, String text2){
         int m = text1.length();
         int n = text2.length();
         if(i==m || j==n) return 0;
         if(memo[i][j]!=-1) return memo[i][j];
         if(text1.charAt(i)==text2.charAt(j)){
          return memo[i][j]=1+rec(i+1,j+1,memo,text1,text2);
         }else{
            return memo[i][j]=Math.max(rec(i+1,j,memo,text1,text2),rec(i,j+1,memo,text1,text2));
         }
     }
     public int longestCommonSubsequence(String text1, String text2) {
          int m = text1.length();
          int n = text2.length();
          int memo[][]=new int[m][n];
          for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                memo[i][j] = -1;
              }
             }
           return rec(0,0,memo,text1,text2);    
     }
}