class Solution {
     public int largestInteger(int[] nums, int k) {
          //TC: O(n)
          //SC: O(n)
          //The hints make it easier :), otherwise unintuit.   
          int n = nums.length; 
          int max = Integer.MIN_VALUE;
          for(int ele:nums){
           max = Math.max(max,ele);
          }
         HashMap<Integer,Integer>hm=new HashMap<>();
         for(int ele:nums){
          hm.put(ele, hm.getOrDefault(ele,0)+1);
         }
         int max_with_only_1=-1;
         for(int ele:nums){
             if(hm.get(ele)==1){
               max_with_only_1 = Math.max(max_with_only_1,ele);
             }
         }
         if(k==1){
          return max_with_only_1;
         }else if(k==n){
            return max;
         }else{
             if(hm.get(nums[0])==1 && hm.get(nums[n-1])==1){
              return Math.max(nums[0],nums[n-1]);
             }else{
                  if(hm.get(nums[0])==1){
                    return nums[0];
                    }
                 else if(hm.get(nums[n-1])==1){
                    return nums[n-1];
                 }
             }
         }
         return -1;
     }
}