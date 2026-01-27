class Solution {
     private static boolean rec(int nums[],int ind,Boolean memo[]){
         int n = nums.length;
         if(ind>=n-1) return true;
         if(memo[ind]!=null) return memo[ind];
         int maxjump = nums[ind];
         for(int i=1;i<=maxjump;i++){
          if(rec(nums,ind+i,memo)) return memo[ind]=true;  
         }
         return memo[ind]=false;
     }
     public boolean canJump(int[] nums) {
      int n = nums.length;
      Boolean memo[]=new Boolean[n+1];  
      return rec(nums,0,memo);   
     }
}