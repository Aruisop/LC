/*

Largest subarray with 0 sum
Solved
Given an array arr[] containing both positive and negative integers, the task is to find the length of the longest subarray with a sum equals to 0.

Note: A subarray is a contiguous part of an array, formed by selecting one or more consecutive elements while maintaining their original order.

Examples:

Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
Output: 5
Explanation: The longest subarray with sum equals to 0 is [-2, 2, -8, 1, 7].
Input: arr[] = [2, 10, 4]
Output: 0
Explanation: There is no subarray with a sum of 0.
Input: arr[] = [1, 0, -4, 3, 1, 0]
Output: 5
Explanation: The longest subarray with sum equals to 0 is [0, -4, 3, 1, 0]
Constraints:
1 ≤ arr.size() ≤ 10^6
−103 ≤ arr[i] ≤ 10^3


*/

class Solution {
    int maxLength(int arr[]) {
         // code here
         // TC: O(n)
         // SC: O(n)
         HashMap<Integer,Integer>hm=new HashMap<>();
         int presum = 0;
         int n = arr.length;
         int maxLen = 0;
         for(int i=0;i<n;i++){
             presum+=arr[i];
             if(presum==0){
                maxLen = i+1;
             }
             if(hm.containsKey(presum)){
                 maxLen = Math.max(maxLen, i-hm.get(presum));
             }else{
                 hm.put(presum,i);
             }
         }
         return maxLen;
    }
}

