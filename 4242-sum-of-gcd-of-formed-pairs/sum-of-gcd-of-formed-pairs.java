class Solution {
     private static int gcd(int a, int b){
      if(b==0) return a;
      return gcd(b, (a%b));
     }
     public long gcdSum(int[] nums) {
       //Brute-Force 
      //TC: O(n*logn)
      //SC: O(n)    
      int n = nums.length;
      int mxi = Integer.MIN_VALUE;
      int preGCD[]=new int[n];
      int mx[]=new int[n];
      Arrays.fill(mx,Integer.MIN_VALUE);
      mx[0] = nums[0];
      for(int i=1;i<n;i++){
         mxi = Math.max(nums[i],mx[i-1]);
         mx[i] = mxi;
      }
      for(int i=0;i<n;i++){
          preGCD[i] = gcd(nums[i],mx[i]);
      }
         Arrays.sort(preGCD);
         int l = 0;
         int r = n-1;
         long sum = 0;
         for(int ele:preGCD){
            System.out.println(ele);
         }
         while(l<r){
             //group l and r
             int ele_in_considern = gcd(preGCD[l],preGCD[r]);
             sum+=ele_in_considern;
             l++;
             r--;
         }
      return sum;
     }
}