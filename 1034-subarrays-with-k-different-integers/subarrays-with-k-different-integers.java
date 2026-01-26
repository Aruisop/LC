class Solution {
     private static int sw(int nums[],int k){
         int l=0,r=0;
         int n = nums.length;
         int ct = 0;
         HashMap<Integer,Integer>hm=new HashMap<>();
         while(r<n){
             hm.put(nums[r],hm.getOrDefault(nums[r],0)+1);
             while(hm.size()>k){
                //dec freq, if 0 remove from map
                hm.put(nums[l],hm.get(nums[l])-1);
                if(hm.get(nums[l])==0) hm.remove(nums[l]);
                //shrink the window by moving l
                l++;
             }
             //ct the subarrs with eles <=k
             ct+=r-l+1;
             r++;
         }
        return ct;
     }
     public int subarraysWithKDistinct(int[] nums, int k) {
        // for k==2
        // subarrs for k==2 and k==1 are found
        // for k==1 (ie k-1)
        // subarrs for k==1 is found
        //subtracting these 2: (k==2 && k==1) - (k==1) we get: (k==2), which is reqd constraint.
        return sw(nums,k)-sw(nums,k-1);
     } 
}