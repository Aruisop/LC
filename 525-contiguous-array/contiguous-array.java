class Solution {
     public int findMaxLength(int[] nums) {
         //heavy optimisation knowledge reqd
         //need to revise
         //TC: O(n)
         //SC: O(n)  
         int n = nums.length;
         HashMap<Integer,Integer>hm=new HashMap<>();
         for(int i=0;i<n;i++){
            if(nums[i]==0) nums[i] = nums[i]-1;
         }
         int presum = 0;
         //for finding length of subarrs starting at 0
         hm.put(0,-1);
         int max = Integer.MIN_VALUE;
         for(int i=0;i<n;i++){
             presum+=nums[i];
             if(hm.containsKey(presum)){
                int targ_ind = hm.get(presum);
                max = Math.max(max,i-targ_ind);
             }else{
                hm.put(presum,i);
             }
         }
         return max==Integer.MIN_VALUE?0:max;
     }
}