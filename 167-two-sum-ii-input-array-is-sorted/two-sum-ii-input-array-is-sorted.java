class Solution {
     private static int bs(int[] numbers, int target,int l,int r){
         while(l<=r){
           int mid = l+(r-l)/2;
           if(numbers[mid]==target){
            return mid;
           }else if(numbers[mid]<target)l=mid+1;
           else r=mid-1;
         }
         return -1;
     }
     public int[] twoSum(int[] numbers, int target) {
         //no use of hashmap as indicated
         //also indices are 1 indexed(what u have to return is 1 indexed)
         //bs is an answer(bforce)
         int n = numbers.length;
         //nlogn complexity
         for(int i=0;i<n;i++){
             int start = numbers[i];
             int key = target-start;
             //start the search space from i+1 to n-1
             int ind2=bs(numbers,key,i+1,n-1);
             if(ind2!=-1) return new int[]{i+1,ind2+1};
         }
         return new int[]{-1,-1};     
     }
}