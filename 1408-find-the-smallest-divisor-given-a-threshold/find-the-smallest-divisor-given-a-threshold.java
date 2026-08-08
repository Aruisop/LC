class Solution {
     public int smallestDivisor(int[] nums, int threshold) {
         //search_space: [1-10^6] 
         //TC: O( search_space*log(search_space) ) 
         //SC: O(1)  
         int l=1;
         int r=(int)1e6;
         while(l<r){
             int mid = l+(r-l)/2;
             int sum =0;
             for(int ele:nums){
              sum+=(ele+mid-1)/mid;
             }
             if(sum>threshold){
                l=mid+1;
             }else{
              r=mid;
             }
         }
        return l; 
     }
}