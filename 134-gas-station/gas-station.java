class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
                   //  //idea is to build up a solution using the bforce idea
    //TC: O(n^2)
    //SC: O(1)
    //  int n = gas.length;
    //  for(int i=0;i<n;i++){
    //      if(gas[i]<cost[i]) continue;
    //      int curr = gas[i];
    //      int j = (i+1)%n;
    //      curr = curr - cost[i] + gas[j];
    //      while(j!=i){
    //         if(curr<cost[j]) break;
    //         int prevcost = cost[j];
    //         j=(j+1)%n;
    //      curr = curr - prevcost + gas[j];
    //      }
    //      if(j==i) return i;
    //  }   
    //  return -1;

     //optimised to
     //TC: O(n)
     //SC: O(1)
     int gsum=0,csum=0;
     int n = gas.length;
     for(int ele:gas)gsum+=ele;
     for(int ele:cost)csum+=ele;
     if(gsum<csum) return -1;
     int total=0;
     int res=0;
     for(int i=0;i<n;i++){
         total+=gas[i]-cost[i];
         if(total<0){
            res=i+1;
            total=0;
         }
     }
     return res;
    }
}