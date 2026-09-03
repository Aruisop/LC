class Solution {
     private static boolean allValid(boolean valid[]){
         for(boolean v:valid){
           if(!v) return false; 
         }
         return true;
     }
     private static void fill_up_valids_and_check_validity(int nums1[], int index, boolean valids[],boolean isOdd,int minOdd){
         int n = nums1.length;
         if(index>=n) return;
         int theoretical_put_onto_nums2  = nums1[index];
         if(isOdd && theoretical_put_onto_nums2%2!=0) valids[index]=true;
         else if(!isOdd && theoretical_put_onto_nums2%2==0) valids[index]=true;
         else{
             //rather than using inner loop, use math logic
             //even-odd=odd
             //odd-odd=even
             //basically whatever is the target parity, we can use the smallestOdd num to our adv
             int theoretical_put_onto_nums2_with_diff = nums1[index]-minOdd;
             if(theoretical_put_onto_nums2_with_diff>=1 && isOdd && theoretical_put_onto_nums2_with_diff%2!=0)valids[index]=true;
             else if(theoretical_put_onto_nums2_with_diff>=1 && !isOdd && theoretical_put_onto_nums2_with_diff%2==0)valids[index]=true;
         }
         fill_up_valids_and_check_validity(nums1,index+1,valids,isOdd,minOdd);  
     }
     public boolean uniformArray(int[] nums1) {
         //TC: O(n)
         //SC: O(n) 
         //possible stack overflow 
         int n = nums1.length;
         //find the minim odd number
         int minOdd = Integer.MAX_VALUE;
         for(int ele:nums1){
            if(ele%2!=0) minOdd = Math.min(minOdd,ele);
         }
         boolean even_valids[]=new boolean[n];
         boolean odd_valids[]=new boolean[n];
         fill_up_valids_and_check_validity(nums1,0,odd_valids,true,minOdd);
         fill_up_valids_and_check_validity(nums1,0,even_valids,false,minOdd);
         return allValid(even_valids) || allValid(odd_valids);
     }
}