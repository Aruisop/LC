class Solution {
     private static void rec(List<Integer>tmp,List<List<Integer>> ans,int[] candidates,int target,int ind){
      if(target==0){
        ans.add(new ArrayList<>(tmp));
        return;
      }
      int n = candidates.length;
      for(int i=ind;i<n;i++){
        if(i>ind && candidates[i]==candidates[i-1])continue;
        if(candidates[i]>target) break;
        tmp.add(candidates[i]);
        rec(tmp,ans,candidates,target-candidates[i],i+1);
        tmp.remove(tmp.size()-1);
      }
     }
     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //always sort before for pretty much any backtracking+no duplis
      Arrays.sort(candidates); 
       List<List<Integer>> ans=new ArrayList<>();
       List<Integer>tmp=new ArrayList<>();
       rec(tmp,ans,candidates,target,0); 
       return ans;
     }
}