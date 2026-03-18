class Solution {
     public List<Integer> majorityElement(int[] nums) {
         //TC: O(n)
         //SC: O(1)----> Space Optimised + Highly Unituitive Boyer Moore Voting Algo :(   
         //idea is to identify that for eles that appear more than n/k times, the possible number is k-1
         //therefore 2 candidates
         int n = nums.length;
         Integer cand1=null,cand2=null;
         int ct1=0,ct2=0;
         List<Integer>ans = new ArrayList<>();
         for(int ele:nums){
          if(cand1!=null && cand1==ele) ct1++;
          else if(cand2!=null && cand2==ele) ct2++;
          else if(ct1==0){
            cand1 = ele;
            ct1 = 1;
          }else if(ct2==0){
             cand2 = ele;
             ct2 = 1;
          }else{
            ct1--;
            ct2--;
          }
         }
         ct1=0;
         ct2=0;
         for(int ele:nums){
            if(cand1==ele) ct1++;
            else if(cand2==ele) ct2++;
         }
         if(ct1>n/3) ans.add(cand1);
         if(ct2>n/3) ans.add(cand2);
         return ans;    
     }
}