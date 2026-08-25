class Solution {
     public int missingMultiple(int[] nums, int k) {
         //slow but bruforce
         Set<Integer>numset=new HashSet<>();
         for(int ele:nums){
            numset.add(ele);
         }
         //2,3,4,6,8
         //2,4,6,8,10
         int min = 0;
          for(int i=k;i<=200;i+=k){
          if(!numset.contains(i)) return i; 
          }
         return -1;
     }
}