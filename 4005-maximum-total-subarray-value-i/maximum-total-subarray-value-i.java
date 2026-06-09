class Solution {
     public long maxTotalValue(int[] nums, int k) {
         //wow
         //TC: O(nlogn)
         //SC: O(n)
         int n = nums.length;
         int copy[] = new int[n];
         int l =0;
         for(int ele:nums){
            copy[l++]=ele;
         }
         Arrays.sort(copy);
         int maxele = copy[n-1];
         int minele = copy[0];
         return (long)(maxele-minele)*k;
         }
}