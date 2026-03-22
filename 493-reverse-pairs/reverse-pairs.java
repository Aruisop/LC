 // class Solution {
 //      public int reversePairs(int[] nums) {
 //        //bforce intuit  
 //        //TC: O(n^2)
 //        //SC: O(1)
 //        int ct = 0;
 //        int n = nums.length; 
 //        for(int i=0;i<n;i++){
 //          for(int j=i+1;j<n;j++){
 //               if((long)nums[i]>(long)2*nums[j]) ct++;
 //           }
 //          } 
 //          return ct;  
 //      }
 // }

 class Solution {
     private static void merge(int nums[], int low, int mid, int high){
         ArrayList<Integer>tmp=new ArrayList<>();
         int left = low;
         int right = mid+1;
         while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){tmp.add(nums[left]); left++;}
            else if(nums[right]<=nums[left]){tmp.add(nums[right]); right++;}
         }
         //leftovers
             while(left<=mid){
               tmp.add(nums[left]);
               left++; 
             }
             while(right<=high){
               tmp.add(nums[right]);
               right++; 
             }
         for(int i=low;i<=high;i++) nums[i]=tmp.get(i-low); 
       }
     private static int mergeSort(int nums[], int low, int high){
        int ct=0;
        int mid = low+(high-low)/2;
        if(low>=high) return ct;
        ct+=mergeSort(nums, low, mid); //left half
        ct+=mergeSort(nums, mid+1, high); //right half
        ct+=countPairs(nums,low,mid,high); //count using 2 ptrs logic for left and right sides
        //merge
        merge(nums, low, mid, high);
        return ct;
     }
     //eval the left the and right sorted parts
     //using ~lar logic to count inversions
     private static int countPairs(int nums[], int low, int mid, int high){
             //imagine 2 ptrs one on the left sorted half {covered by i-----> low, mid} 
             //the other one on the right half covered by right {from mid+1...high}  
             //long is type casted in case of overflow :(
             int right = mid+1;
             int ct = 0;
             for(int i=low;i<=mid;i++){
             while(right<=high && (long)nums[i]>(long)2*nums[right]) right++;
              ct += (right-(mid+1));
             }
             return ct;
         }
     public int reversePairs(int[] nums) {
         //TC: O(nlogn)
         //SC: O(n) {temp al in merge step} + O(logn) {rec stack of mergesort}
         int n = nums.length;
         return mergeSort(nums, 0, n-1);
      }
 }