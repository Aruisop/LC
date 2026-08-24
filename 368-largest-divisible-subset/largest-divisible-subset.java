class Solution {
     public List<Integer> largestDivisibleSubset(int[] nums) {
       //TC: O(n^2)
       //SC: O(n) 
       int n = nums.length;
       Arrays.sort(nums);
       int dp[]=new int[n];
       Arrays.fill(dp,1);
       List<Integer>ans=new ArrayList<>();
       int parent[]=new int[n];
       Arrays.fill(parent,-1);
       int lastIndex = -1;
       int maxIndex = 0;
         for(int i=0;i<n;i++){
             for(int j=0;j<i;j++){
                 if(nums[i]%nums[j]==0 && dp[i]<dp[j]+1){
                   dp[i] = dp[j]+1;
                   parent[i]=j;
                 }
             }
             if(dp[i]>maxIndex){
               maxIndex = dp[i];
               lastIndex = i;   
             }
         }
         while(lastIndex!=-1){
            ans.add(nums[lastIndex]);
            lastIndex=parent[lastIndex];
         }
         Collections.reverse(ans);
         return ans;   
     }
}