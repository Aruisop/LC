class Solution {
     private static void btrack(int[] candidates, int target,List<Integer>tmp,List<List<Integer>> ans,int ind){
         int n = candidates.length;
         if(target<0) return;
         if(target==0){
            ans.add(new ArrayList<>(tmp));
            return;
         }
         for(int i=ind;i<n;i++){ 
           tmp.add(candidates[i]);
           btrack(candidates,target-candidates[i],tmp,ans,i);
           tmp.remove(tmp.size()-1);  
         }
     }
     public List<List<Integer>> combinationSum(int[] candidates, int target) {
          //realised that one small base case is crucial, rest everything follows std template. 
           List<Integer>tmp=new ArrayList<>();
           List<List<Integer>> ans = new ArrayList<>();
           btrack(candidates,target,tmp,ans,0);
           return ans;
     }
}