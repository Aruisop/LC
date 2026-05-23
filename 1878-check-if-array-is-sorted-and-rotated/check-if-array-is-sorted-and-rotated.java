class Solution {
     public boolean check(int[] nums) {
         //TC: O(n^2)
         //SC: O(n)
         int n = nums.length;
         int b[] = new int[n];
         for(int i=0;i<n;i++){
            b[i]=nums[i];
         }
         //prev submit didnt work for duplis
         Arrays.sort(nums);
         for(int x=0;x<n;x++){
             if(b[0]!=nums[x]) continue;
             boolean flag = true;
             for(int i=0;i<n;i++){
               if(b[i]!=nums[(i+x)%n]){
                flag=false;
                break;
               }
             }
             if(flag==true) return true;
         }
        return false; 
     }
}