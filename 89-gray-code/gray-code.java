class Solution {
     public List<Integer> grayCode(int n) {
         //Optimal
         //TC: O(n) 
         //SC: O(n)
         List<Integer>ans = new ArrayList<>();
         ans.add(0);
         //idea is to not use the reversal technique
         //and use bit manipulation
         for(int i=1;i<Math.pow(2,n);i++){
             //xor btw the curr and prev vals 
             ans.add(i^(i>>1));
          }
         return ans;  
     }
}