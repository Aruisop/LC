class Solution {
     private static int rec(int low,int high,int memo[][]){
         if(low>=high) return 1;
         if(memo[low][high]!=-1) return memo[low][high];
         int ct=0;
         //ith ele is root,go to left and right
         //multiply left and right subtrees numbers and add to res
         for(int i=low;i<=high;i++){
          ct+=rec(low,i-1,memo)*rec(i+1,high,memo);
         } 
         return memo[low][high]=ct;
     }
     public int numTrees(int n) {
           //rec memo solution
           //here we go from 1 to n and
           //find a root in b/w
           int memo[][]=new int[n+1][n+1];
           for(int i=0;i<n+1;i++){
            Arrays.fill(memo[i],-1);
           }
           return rec(1,n,memo);
     }
}