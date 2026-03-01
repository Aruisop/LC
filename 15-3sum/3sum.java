class Solution {
     public List<List<Integer>> threeSum(int[] nums) {
     //   //bforce involves using a set using the curr method
     //   //TC: O(n^3) ouch!
     //   //SC: O(n^2)
     //   int n = nums.length;
     //   HashSet<List<Integer>>ans=new HashSet<>();
     //   for(int i=0;i<n;i++){
     //      for(int j=i+1;j<n;j++){
     //          for(int k=j+1;k<n;k++){
     //           if(nums[i]+nums[j]+nums[k]==0){
     //             List<Integer>tmp=new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k]));
     //             Collections.sort(tmp);
     //             ans.add(tmp);
     //           }
     //          }
     //      }
     //   }
     //   List<List<Integer>>finans=new ArrayList<>(ans);
     //   return finans;   
    
     //better approach is use 2 ptrs+sort(IMP);
     //TC: O(n^2)
     //SC: O(n^2)
     int n = nums.length;
     Arrays.sort(nums);
     List<List<Integer>> ans = new ArrayList<>();
     for(int i=0;i<n;i++){
         int l=i+1;
         int r=n-1;
         //skip duplis
         if(i-1>=0 && nums[i-1]==nums[i]) continue;
         while(l<r){
          if(nums[i]+nums[l]+nums[r]==0){
            ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
            l++;
            r--;
            //skip duplis here also
            while(l<r && nums[l-1]==nums[l]) l++;
            while(l<r && nums[r]==nums[r+1]) r--;
          }else if(nums[i]+nums[l]+nums[r]<0) l++;
          else r--;
         }
     }
     return ans;
     }
}