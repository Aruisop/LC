class Solution {
     public List<Integer> majorityElement(int[] nums) {
     //TC: O(n), BRUTE FORCE
     //SC: O(n)   
     int n = nums.length;
     HashMap<Integer,Integer>hm=new HashMap<>();
     for(int ele:nums){
     hm.put(ele,hm.getOrDefault(ele,0)+1);
     }
     List<Integer>ans=new ArrayList<>();
     for(int i=0;i<n;i++){
        if(!ans.contains(nums[i]) && hm.get(nums[i])>n/3) ans.add(nums[i]);
     }
     return ans;
     }
}