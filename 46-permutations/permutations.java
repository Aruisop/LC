class Solution {
     private static void rec(int[] nums,List<Integer>tmp,List<List<Integer>>ans){
         int n = nums.length;
         if(tmp.size()==n){
            ans.add(new ArrayList<>(tmp));
            return;
         }
         for(int i=0;i<n;i++){
            if(tmp.contains(nums[i])) continue;
            tmp.add(nums[i]);
            rec(nums,tmp,ans);
            tmp.remove(tmp.size()-1);
         }
     }
     public List<List<Integer>> permute(int[] nums) {
        List<Integer>tmp=new ArrayList<>();
        List<List<Integer>>ans=new ArrayList<>();
        rec(nums,tmp,ans);
        return ans;
     }
}