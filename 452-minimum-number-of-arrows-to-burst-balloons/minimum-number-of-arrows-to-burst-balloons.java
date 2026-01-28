class Solution {
     public int findMinArrowShots(int[][] points) {
      int n = points.length;
      Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
      //initiallly have n arrows for n baloons
      int arrows = n;
      for(int i=1;i<n;i++){
         //find overlap and merge intervals
         if(points[i-1][1]>=points[i][0]){
         arrows--;
         //update the intervals
         points[i][0]=Math.max(points[i-1][0],points[i][0]);
         points[i][1]=Math.min(points[i-1][1],points[i][1]);
         }
      }
      return arrows;
     }
}