class Solution {
     private static int hr1(int stind, int endind, int nums[],int memo[]){
       if(stind>endind) return 0;
       if(memo[stind]!=-1) return memo[stind];
       int leave = hr1(stind+1,endind,nums,memo);
       int take =  nums[stind]+hr1(stind+2,endind,nums,memo);
       memo[stind]=Math.max(leave,take);
       return memo[stind];
     }
     public int rob(int[] nums) {
        // rec memo solution
        //TC: O(n)
        //SC: O(n+n) ---> memo+rec-stack
        int n = nums.length;
        if(n==1) return nums[0];
        int memo1[]=new int[n];
        Arrays.fill(memo1,-1);
        int memo2[]=new int[n];
        Arrays.fill(memo2,-1);
        return Math.max(hr1(0,n-2,nums,memo1),hr1(1,n-1,nums,memo2));    
     }
}