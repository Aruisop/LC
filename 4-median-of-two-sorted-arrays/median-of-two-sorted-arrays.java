class Solution {
     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      //O(m+n) worse in tc and not what the q expects. But deffo more intuitive
      int m = nums1.length;
      int n = nums2.length;
      int i=0,j=0;
      int prev=0,curr=0;
      int ct=0;
      int mid = (m+n)/2;
      while(ct<=mid){
        prev=curr;
        //i finished so only possibilty is to take from other arr and move j
        if(i==m) curr = nums2[j++];
        else if(j==n) curr = nums1[i++];
        else if(nums1[i]<=nums2[j]) curr=nums1[i++];
        else curr=nums2[j++];
        ct=ct+1;
      }
      //if even
      if((m+n)%2==0){
        return (prev+curr)/2.0;
      }
      //for odd length
      return curr;    
     }
}