class Solution {
     public void rotate(int[] nums, int k) {
         //abs bforce
         // TC: O(n)
         //SC: O(n)  
         int n=nums.length;
         int ct =0;
         if(k>n) k=k%n;
         List<Integer>temp=new ArrayList<>();
         for(int i=n-1;i>=0;i--){
             if(ct<k){
              temp.add(nums[i]);
              ct++;
             }
         }
         Collections.reverse(temp);
         List<Integer>eles_before = new ArrayList<>();
         for(int i=0;i<n-k;i++){
            eles_before.add(nums[i]);
         }
         for(int ele:eles_before){
            temp.add(ele);
         }
         int finans[] = new int[n];
         int idx = 0;
         for(int ele:temp){
            finans[idx++]=ele;
         }
         for(int ele:finans){
            System.out.println(ele);
         }
         int n_idx = 0;
         for(int ele:finans){
            nums[n_idx++]=ele;
         }
     }
}