class Solution {
     private static int rec(int ind,int piles[],int M,int suffix[], int memo[][]){
         int n = piles.length;
         if(ind>=n) return 0;
    
         //this is not st-forward
         if(2*M>=n-ind) return suffix[ind];
         
         if(memo[ind][M]!=-1) return memo[ind][M];

         int max = 0;
         //vary X from 1 to 2*M  
         for(int X=1;X<=2*M;X++){
             //update M each time X has been selected
             int opp = rec(ind+X,piles,Math.max(M,X),suffix,memo);
             int stones = suffix[ind]-opp;
             max = Math.max(max,stones);
         }
         return memo[ind][M]=max;
     }
     public int stoneGameII(int[] piles) {
         //TC: O(n^2) memoisation
         //SC: O(n^2)    
         int n  = piles.length;
         int memo[][]=new int[n][n];
         for(int mem[]:memo){
            Arrays.fill(mem,-1);
         }
         int sum = 0;
         for(int ele:piles){
          sum+=ele;
         }
         int suffix[]=new int[n];
         suffix[0]=sum;
         for(int i=1;i<n;i++){
           suffix[i]=suffix[i-1]-piles[i-1];
         }
         return rec(0,piles,1,suffix,memo);
     }
}