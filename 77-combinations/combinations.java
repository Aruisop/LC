class Solution {
     private static void rec(List<List<Integer>>ans,List<Integer>tmp,int ind,int n,int k){
         if(k==0){
         ans.add(new ArrayList<>(tmp));
         return;
         }
          for(int i=ind;i<=n;i++){
            tmp.add(i);
            rec(ans,tmp,i+1,n,k-1);
            tmp.remove(tmp.size()-1);
          }
     }
     public List<List<Integer>> combine(int n, int k) {
          List<List<Integer>> ans = new ArrayList<>();
          List<Integer>tmp=new ArrayList<>();
          rec(ans,tmp,1,n,k);
          return ans;
     }
}