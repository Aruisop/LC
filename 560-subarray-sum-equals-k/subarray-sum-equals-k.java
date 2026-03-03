class Solution {
     public int subarraySum(int[] nums, int k) {
      //Optimal solution w/ HashMap
      //idea is to ct the prefsums at each instance 
      //and check if prefsum-k exists in the hashmap
      //for a prefix sum ==0 always 1 subarr exists (hm.put(0,1))
      //Unintuit AF.
      //TC: O(n)
      //SC: O(1)
      int ct=0;
      HashMap<Integer,Integer>hm=new HashMap<>(); 
      hm.put(0,1);
      int presum=0;
      int n = nums.length;
      for(int i=0;i<n;i++){
         presum+=nums[i];
         if(hm.containsKey(presum-k)){
          ct+=hm.get(presum-k);
         }
         //put the presum into the hashmap, and ct its freq
         hm.put(presum,hm.getOrDefault(presum,0)+1);
      }
      return ct;   
     }
}