class Solution {
     private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
     }
     private static void reverse(int nums[], int l, int r){
        while(l<r) swap(nums,l++,r--);
     }
     public void nextPermutation(int[] nums) {
         //next lexicographically gr8er is imp
         // rel intuitive soln
         //TC: O(n)
         //SC: O(1) 
         int n = nums.length;
         int ind = -1;
         //find the ele that breaks the sorted order (from last ele onwards the order shld be increasing)
         for(int i=n-2;i>=0;i--){
             if(nums[i]<nums[i+1]){
                ind=i;
                break;
             }
         }
         if(ind==-1){
            Arrays.sort(nums);
         }
         //next once the ele is found that breaks order, swap it with the first larger ele than ind
         for(int i=n-1;i>=ind;i--){
           if(ind!=-1 && nums[i]>nums[ind]){
            swap(nums,ind,i);
            break;
           }
         }
         //finally the next lexico gr8er seq is just the left half+sortedright half
         if(ind!=-1) reverse(nums, ind+1, n-1);
     }
}