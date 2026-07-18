/*
3312. Sorted GCD Pair Queries

You are given an integer array nums of length n and an integer array queries.

Let gcdPairs denote an array obtained by calculating the GCD of all possible pairs (nums[i], nums[j]), where 0 <= i < j < n, and then sorting these values in ascending order.

For each query queries[i], you need to find the element at index queries[i] in gcdPairs.

Return an integer array answer, where answer[i] is the value at gcdPairs[queries[i]] for each query.

The term gcd(a, b) denotes the greatest common divisor of a and b.


*/


class Solution {
     private static int gcd(int a, int b){
         if(b==0) return a;
         return gcd(b,(a%b));
     }
     public int[] gcdValues(int[] nums, long[] queries) {
             //Bforce
             //TC: O(n*n) 
             //SC: O(n)    
             //bottleneck part is enumerating all the pairs, which is not required, and needs optimization 
             int n = nums.length;
             List<Integer>gcdPairs = new ArrayList<>();
             for(int i=0;i<n;i++){
              for(int j=i+1;j<n;j++){
                 gcdPairs.add(gcd(nums[i],nums[j]));
                 }
             }
             int gcp_arr[]=new int[gcdPairs.size()];
             int k = 0;
             for(int ele:gcdPairs){
                gcp_arr[k++]=ele;
             }  
             Arrays.sort(gcp_arr);
              List<Integer>ans=new ArrayList<>();
             for(long qu:queries){
                ans.add(gcp_arr[(int)qu]);
             }
             int ans_arr[]=new int[ans.size()];
             int ans_ind = 0;
             for(int ele:ans){
                ans_arr[ans_ind++]=ele;
             }
             return ans_arr;
     }
}
