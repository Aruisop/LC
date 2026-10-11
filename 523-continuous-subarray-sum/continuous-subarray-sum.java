// class Solution {
//      public boolean checkSubarraySum(int[] nums, int k) {
//          // Bru-Force
//          //TC: O(n^3)
//          //SC: O(1)
//          int n = nums.length;
//          //check for good subarray
//          int l =0, r=0;
//          for(int i=l;i<n;i++){
//              for(int j=r;j<n;j++){
//                int sum = 0;
//                  int sub_len = j-i+1;
//                  if(sub_len>=2){
//                   for(int m=i;m<=j;m++){
//                     sum+=nums[m];
//                   }
//                 //   System.out.println(sum);
//                   if(sum%k==0) return true;
//                  }
//              }
//          }
//          return false; 
//      }
// }
class Solution {
     public boolean checkSubarraySum(int[] nums, int k) {
         //TC: O(n)
         //SC: O(n)
         HashMap<Integer,Integer>hm=new HashMap<>();
         int presum = 0;
         int n = nums.length;
         int pref[]=new int[n];
         int m = 0;
         for(int ele:nums){
            presum+=ele;
            pref[m++]=presum;
         }
         hm.put(0,-1);
         for(int i=0;i<n;i++){
             int rem = pref[i]%k; 
             if(hm.containsKey(rem)){
                     //their difference will be divisible by k for sure.
                     //as at both the indices, the prefix-sum's are divisbile by k.
                     int diff = i-hm.get(rem);
                     //ensures that the length of the subarr is >=2
                     if(diff>=2) return true;
              }else{
                hm.put(rem,i);
              }
         }
         return false;
     }
}