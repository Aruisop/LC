class Solution {
     private static void rec(List<List<Integer>>ans, List<Integer>temp,int nums[],boolean used[]){
         int n = nums.length;
         if(temp.size()==n){
           ans.add(new ArrayList<>(temp));
           return;
         }
         for(int i=0;i<n;i++){
            if(used[i]) continue;
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
            used[i]=true;
            temp.add(nums[i]);
            rec(ans,temp,nums,used);
            temp.remove(temp.size()-1);
            used[i]=false;
         }
     }
     public List<List<Integer>> permuteUnique(int[] nums) {
         //follows standard templeate of Perm1, only diff is to check
         //whether prev ele has alr been used or not; if not we cant use the curr ele
         //TC: O(n*n!)----> for each ele perms are at n!; and for n eles it is n*n!
         //SC: O(n)
         Arrays.sort(nums);
         int n = nums.length;
         boolean used[]=new boolean[n];
         List<List<Integer>>ans=new ArrayList<>();
         rec(ans,new ArrayList<>(),nums,used);
         return ans;
     }
}