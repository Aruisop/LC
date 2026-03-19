class Solution {
     public int majorityElement(int[] nums) {
     //n/k logic for k-1 candidates
     //therefore only 1 cand
     //TC: O(n)
     //SC: O(1)
     int n = nums.length;
     //BM voting algo starts with identifying the cand
     Integer cand1 = null;
     int ct1=0;
     for(int ele:nums){
         if(cand1!=null && ele==cand1){
           ct1++;   
         }else if(ct1==0){
          cand1 = ele;
          ct1 = 1;
         }else{
            ct1--;
         }
     }
     //reset the ct
     //and check if the candidate matches the currele
     //if so incr ct
     ct1 = 0;
     for(int ele:nums){
        if(cand1==ele) ct1++;
     }
      if(ct1>n/2) return cand1;
      return -1;
     }
}