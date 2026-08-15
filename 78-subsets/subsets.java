class Solution {
     public List<List<Integer>> subsets(int[] nums) {
         //used bitmasking {unintuitive} 
         //TC: O(n*(2^n)) 
         //SC: O(n*(2^n))
         int n = nums.length;
         List<List<Integer>>ans=new ArrayList<>();
         for(int i=0;i<(1<<n);i++){
             List<Integer>tmp=new ArrayList<>();
             for(int j=0;j<n;j++){
                if( ((1<<j)&i) !=0) tmp.add(nums[j]);
             }
             ans.add(new ArrayList<>(tmp));
         }
         return ans;  
     }
}