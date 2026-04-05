class Solution {
     private static int rec(int new1[],int new2[],int ind,int swapped,int memo[][]){
         int n = new1.length;
         if(ind==n) return 0;
         if(memo[ind][swapped]!=-1) return memo[ind][swapped];
         //minimising the swaps
         int ans = Integer.MAX_VALUE;
         int prev1 = new1[ind-1];
         int prev2 = new2[ind-1];
         //if the swap is needed swap the prevs 
         if(swapped==1){
            int temp = prev1;
            prev1 = prev2;
            prev2 = temp;
         }
         //alr incr seq, so no need to swap case
         if(new1[ind]>prev1 && new2[ind]>prev2){
            ans = rec(new1,new2,ind+1,0,memo);
         }
         //swap reqd case
         if(new1[ind]>prev2 && new2[ind]>prev1){
            ans = Math.min(ans, 1+rec(new1,new2,ind+1,1,memo));
         }
         return memo[ind][swapped]=ans;
     } 
     public int minSwap(int[] nums1, int[] nums2) {
         //TC: O(n*2)+O(n){rec stack space} ~ O(n)
         //SC: O(2*n+2+(n+1)*2) ~ O(n)
         int n = nums1.length;
         int new1[]=new int[n+1];
         int new2[]=new int[n+1];
         new1[0]=-1;
         new2[0]=-1;
         for(int i=1;i<n+1;i++){
            new1[i]=nums1[i-1];
            new2[i]=nums2[i-1];
         }
         int memo[][]=new int[n+1][2];
         for(int mem[]:memo) Arrays.fill(mem,-1);
         return rec(new1,new2,1,0,memo);
     }
}