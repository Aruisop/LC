///IMP CONCEPT: BS on ANS (imp) {mini-maxi optimisation}
class Solution {
     private static boolean canAllocate(int[] arr,int n, int k,int maxPages){
      //currently allocated pages
      int currPages=0;
      //no of students
      int stu=1;
      for(int i=0;i<n;i++){
          if(currPages+arr[i]>maxPages){
              stu++;
              if(stu>k) return false;
              currPages=arr[i];
          }else currPages+=arr[i];
      }
      return true;
     }
     public int findPages(int[] arr, int k) {
         // code here
         //Optimal TC: O(log(n)*k)
         //SC: O(1)
         //Unintuitive Af.
         int n = arr.length;
         if(k>n) return -1;
         int sum=0;
         for(int ele:arr){
             sum+=ele;
         }
         int max=0;
         for(int ele:arr){
             max=Math.max(max,ele);
         }
         int lo=max;
         int hi=sum;
         int res=0;
         while(lo<=hi){
             int mid = lo+(hi-lo)/2;
             if(canAllocate(arr,n,k,mid)){
                 res=mid;
                 hi=mid-1;
             }else lo=mid+1;
         }
         return res;
    }
}
