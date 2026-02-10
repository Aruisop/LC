class Solution {
     private static void rec(List<Integer>tmp,List<List<Integer>> ans,int ind,int k,int n){
         if(k==0 && n==0){
           ans.add(new ArrayList<>(tmp));
           return;
         }
         for(int i=ind;i<=9;i++){
            if(i>n) break;
            tmp.add(i);
            rec(tmp,ans,i+1,k-1,n-i);
            tmp.remove(tmp.size()-1);
         }
     }
     public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer>tmp=new ArrayList<>();
        List<List<Integer>> ans =new ArrayList<>();
        rec(tmp,ans,1,k,n);
        return ans;
     }
}