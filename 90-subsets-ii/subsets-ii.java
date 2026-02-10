class Solution {
     private static void backtrack(HashSet<List<Integer>>hs,List<Integer>tmp,int ind,int nums[]){
         hs.add(new ArrayList<>(tmp));
         int n = nums.length;
         for(int i=ind;i<n;i++){
            tmp.add(nums[i]);
            backtrack(hs,tmp,i+1,nums);
            tmp.remove(tmp.size()-1);
         }
     } 
     public List<List<Integer>> subsetsWithDup(int[] nums) {
        //not space optimised..
        HashSet<List<Integer>>hs=new HashSet<>();
        List<Integer>tmp=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(hs,tmp,0,nums);
        List<List<Integer>>ans=new ArrayList<>();
        for(List<Integer>ele:hs) ans.add(new ArrayList<>(ele));
        return ans;
     }
}