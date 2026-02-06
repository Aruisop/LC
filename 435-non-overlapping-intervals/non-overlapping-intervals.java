class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         //normal checking for overlap, except for the 
         //greedy sorting 
         int n = intervals.length;
         Arrays.sort(intervals,(a,b)->(a[1]-b[1]));
         int prevend = intervals[0][1];
         int ct=0;
         for(int i=1;i<n;i++){
             if(intervals[i][0]<prevend){
                ct++;
             }else{
                prevend = intervals[i][1];
             }
         }
         return ct;
    }
}