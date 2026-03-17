class Solution {
     public int maxArea(int[] height) {
     //TC: O(n)
     //SC: O(1)
     //the most intuitive way is to go about comparing the hts btw the l and r ptrs
     //calc area based on these 2 hts and find the final ans
     int max = Integer.MIN_VALUE;
     int n = height.length;
     int l = 0;
     int r = n-1;
     while(l<=r){
      int area = (r-l)*(Math.min(height[l],height[r]));
      max = Math.max(max,area);
      if(height[l]<height[r]) l++;
      else r--;
     }
     return max;
     }
}