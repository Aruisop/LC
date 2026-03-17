class Solution {
     public int[][] insert(int[][] intervals, int[] newInterval) {
         //TC: O(nlogn)---> bruteforce
         //SC: O(n)
         int n = intervals.length;
         List<int[]>ans = new ArrayList<>();
         //merge+insert
         for(int i=0;i<n;i++){
            ans.add(intervals[i]);
         }
         ans.add(newInterval);
         Collections.sort(ans, (a,b)->(a[0]-b[0]));
         int anlen = ans.size();
         int finans[][]=new int[anlen][2];
         for(int i=0;i<anlen;i++){
         finans[i]=ans.get(i);
         }
         List<int[]>inter=new ArrayList<>();
         int prev[] = finans[0];
         for(int i=1;i<anlen;i++){
             int curr[]=finans[i];
             //overlap
             if(curr[0]<=prev[1]){
                 prev[1]=Math.max(curr[1],prev[1]);
             }else{
                inter.add(prev);
                prev=curr;
             }         
         }
         inter.add(prev);
         int fans[][]=new int[inter.size()][2];
         for(int i=0;i<fans.length;i++){
            fans[i][0]=inter.get(i)[0];
            fans[i][1]=inter.get(i)[1];
         }
        
         return fans;     
     }
}