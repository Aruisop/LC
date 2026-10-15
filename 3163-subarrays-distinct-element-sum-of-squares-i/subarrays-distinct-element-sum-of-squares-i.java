class Solution {
     public int sumCounts(List<Integer> nums) {
         //Better Bru-Force
         //TC: O(n^2)
         //SC: O(n)  
         int n = nums.size();
         int globSum =0;
         for(int i=0;i<n;i++){
              HashSet<Integer>hs=new HashSet<>();
             for(int j=i;j<n;j++){
                 if(!hs.contains(nums.get(j))){
                    hs.add(nums.get(j));
                 }
                  globSum+=hs.size()*hs.size();
             }
         }
         return globSum;
     }
}