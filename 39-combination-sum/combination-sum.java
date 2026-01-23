class Solution {
     private static void rec(int[] candidates,List<List<Integer>>ans,List<Integer>tmp,int ind,int target){
         int n = candidates.length;
         if(ind>=n || target<0) return;
         if(target==0){
            ans.add(new ArrayList<>(tmp));
            return;
         }
         tmp.add(candidates[ind]);
         rec(candidates,ans,tmp,ind,target-candidates[ind]);
         tmp.remove(tmp.size()-1);
         rec(candidates,ans,tmp,ind+1,target);
     }
     public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>tmp=new ArrayList<>();
        rec(candidates,ans,tmp,0,target);
        return ans;
     }
}