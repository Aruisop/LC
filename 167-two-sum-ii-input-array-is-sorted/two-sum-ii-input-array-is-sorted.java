class Solution {
    public int[] twoSum(int[] numbers, int target) {
     //O(n) optimality using 2 ptrs
     //init thought of using l=0,r=0;
     //but that doesnt reduce the search space as the sum keeps increasing
     //as the array is sorted we need to be smart in decreasing the search space
     int n = numbers.length;
     int l=0;
     int r=n-1;   
     while(l<=r){
         int sum = numbers[l]+numbers[r];
         if(sum==target) return new int[]{l+1,r+1};
         else if(sum<target){
            //improve the sum
          l++;
         }else{
            //decrement the sum
            r--;
         }
     }
     return new int[]{-1,-1};
     }
}