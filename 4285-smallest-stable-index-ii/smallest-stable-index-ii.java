class Solution {
     public int firstStableIndex(int[] nums, int k) {
             //TC: O(n)
             //SC: O(n)    
             int n = nums.length;
             int max_till_i[]=new int[n];
             int min_from_last_to_i[]=new int[n];
             int max = Integer.MIN_VALUE;
             int min = Integer.MAX_VALUE;
             for(int i=0;i<n;i++){
             max = Math.max(max,nums[i]);
             max_till_i[i]=max;
             }
             for(int i=n-1;i>=0;i--){
             min = Math.min(min,nums[i]);
             min_from_last_to_i[i]=min;
             }
             boolean validity[]=new boolean[n];
             for(int i=0;i<n;i++){
                if(max_till_i[i]-min_from_last_to_i[i]<=k)
                validity[i]=true;
             }
             int min_valid_index = Integer.MAX_VALUE;
             for(int i=0;i<n;i++){
               if(validity[i]) min_valid_index = Math.min(min_valid_index,i);
             }
         return (min_valid_index==Integer.MAX_VALUE)?-1:min_valid_index;
     } 
}