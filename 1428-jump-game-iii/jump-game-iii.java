class Solution {
     private static boolean iszero(int ind, int n,int[] arr){
         if(ind<n && arr[ind]==0) return true;
         return false; 
     }
     private static boolean rec(int[] arr,int ind, boolean vis[]){
         int n = arr.length;
         if(ind<0 || ind>=n) return false;
         if(ind<n && iszero(ind,n,arr)){
           return true;
         }
         boolean gonext = false, goback = false;
         vis[ind]=true;
         if(ind+arr[ind]<n && !vis[ind+arr[ind]]) gonext = rec(arr,ind+arr[ind],vis);
         if(ind-arr[ind]>=0 && ind-arr[ind]<n && !vis[ind-arr[ind]]) goback = rec(arr,ind-arr[ind],vis);
         return (gonext || goback);
         
     }
     public boolean canReach(int[] arr, int start) {
         //TC: O(n) DFS, init approach relied on only using rec; causing inf recursion
         // needed to add a vis and make it dfs-like to prevent this
         //SC: O(n)
          int n = arr.length;
          //check if jump to a '0' index is possible
          boolean vis[]=new boolean[n];
          return rec(arr,start,vis);
     }
}