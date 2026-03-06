class Solution {
     private static boolean rec(int i, int j, int k, String s1, String s2, String s3,Boolean memo[][][]){
         int n1 = s1.length();
         int n2 = s2.length();
         int n3 = s3.length();
         //only check for k
         if(k==n3) return true;
         if(memo[i][j][k]!=null) return memo[i][j][k];
         boolean ans=false;
         //case where all first chars are same
         if(i<n1 && j<n2 && s1.charAt(i)==s2.charAt(j) && s2.charAt(j)==s3.charAt(k)){
             ans = rec(i+1,j,k+1,s1,s2,s3,memo) || rec(i,j+1,k+1,s1,s2,s3,memo);
         }else{
             //select the char in s3 that appears in either s1/s2
             if(i<n1 && k<n3 && s1.charAt(i)==s3.charAt(k)) ans = rec(i+1,j,k+1,s1,s2,s3,memo);
             else if(j<n2 && k<n3 && s2.charAt(j)==s3.charAt(k)) ans = rec(i,j+1,k+1,s1,s2,s3,memo);
         }
         return memo[i][j][k]=ans; 
     }
     public boolean isInterleave(String s1, String s2, String s3) {
         //extreme intuition drawn soln, sort of built this on my own
         //excluding maybe the base case of k==n3 :(
         //not the most optimal as it uses a 3d dp, which shld be a 2d one, next commit fixes that
         //TC: O(n1*n2)
         //SC: O(n1*n2*n3)
         int n1 = s1.length();
         int n2 = s2.length();
         int n3 = s3.length();
         Boolean memo[][][]=new Boolean[n1+1][n2+1][n3+1]; 
         if((n1+n2)!=n3) return false;
         return rec(0,0,0,s1,s2,s3,memo);    
     }
}