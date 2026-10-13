class Solution {
     public long maxAlternatingSum(int[] nums) {
             //TC: O(nlogn)
             //SC: O(n) 
             long ans = 0;
             Arrays.sort(nums);
             int n=nums.length;
             long squares[]=new long[n];
             int k=0;
             for(int ele:nums){
                squares[k++]=(long)(ele*ele);
             }
             Arrays.sort(squares);
             int l =0;
             int r =n-1;
             int ind =0;
             while(l<=r){
                 if(ind%2==0){
                 ans+=squares[r];
                 r-=1;
                 ind+=1;
                 }else{
                 ans-=squares[l];
                 l+=1;
                 ind+=1;
                 }
             }
             return ans; 
     }
}