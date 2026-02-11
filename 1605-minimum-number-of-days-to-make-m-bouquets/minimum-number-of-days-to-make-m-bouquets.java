class Solution {
     private static int canBloom(int k,int targday,int[] bloomDay){
         int n = bloomDay.length;
         int consec =0;
         int boquets=0;
         for(int i=0;i<n;i++){
              if(targday>=bloomDay[i]){
              consec++;
              }else{
                consec=0;
              }
             if(consec==k){
                boquets++; 
                consec=0;
             }
         }
         return boquets;
     }
     public int minDays(int[] bloomDay, int m, int k) {
        //optimal bin search
     int max =Integer.MIN_VALUE;
     for(int ele:bloomDay){
        max=Math.max(max,ele);
     }
     int l = 0;
     int r = max;
     int res = -1;
     while(l<=r){
         int mid = l+(r-l)/2;
         //check if the mid day has at least m boquets
         if(canBloom(k,mid,bloomDay)>=m){
          res=mid;
          r=mid-1;
         }else{
            l=mid+1;
         }
     }
     return res; 
     }
}