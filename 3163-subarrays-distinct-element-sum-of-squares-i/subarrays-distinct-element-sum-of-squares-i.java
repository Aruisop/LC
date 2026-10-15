class Solution {
     public int sumCounts(List<Integer> nums) {
         //Bru-Force
         //TC: O(n^3)
         //SC: O(n)  
         int n = nums.size();
         int globSum =0;
         for(int i=0;i<n;i++){
             for(int j=i;j<n;j++){
                 HashSet<Integer>hs=new HashSet<>();
                 for(int k=i;k<=j;k++){
                  if(!hs.contains(nums.get(k))){
                     hs.add(nums.get(k));
                  }
                 }
                 int sum = 0;
                 int size = hs.size();
                 sum+=size*size;
                 globSum+=sum;
             }
         }
         return globSum;
     }
}