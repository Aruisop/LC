class Solution {
     public int[] rearrangeArray(int[] nums) {
         int n = nums.length;
         //n is even
         //n/2 odd and even
         //TC; O(n)
         //SC: O(n)
         int ans[]=new int[n];
         int k = 0;
         List<Integer>pos=new ArrayList<>();
         List<Integer>neg=new ArrayList<>();
         for(int i=0;i<n;i++){
           if(nums[i]>0) pos.add(nums[i]);
           else neg.add(nums[i]);
         }
         //pos
         int s1=0;
         //neg
         int s2=0;
         while(s1<n/2 && s2<n/2){
            ans[k++]=pos.get(s1);
            ans[k++]=neg.get(s2);
            s1++;
            s2++;
         }
         return ans;
     }
}