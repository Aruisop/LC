class Solution {
     public double angleClock(int hour, int minutes) {
         //TC: O(60+12) ~ O(1)
         //SC: O(60+12) ~ O(1)
         //exp angle-offset by hour hand moving
         //offset by hour hand moving == 
         // - 30 mins -> 15 deg
         // - 60 mins -> 30 deg
         // - 15 mins -> 7.5 deg
         // one more thing 6 deg movement per minute
         HashMap<Integer,Integer>mintodegmap = new HashMap<>();
         HashMap<Integer,Integer>hourtodegmap = new HashMap<>();
         int minoff = 0,houroff=0;
         mintodegmap.put(0,360);
         for(int i=1;i<=60;i++){
              minoff+=6;
              mintodegmap.put(i,minoff);
         }
         hourtodegmap.put(0,0);
         for(int i=1;i<=12;i++){
              houroff+=30;
              hourtodegmap.put(i,houroff);
         }
         double expected_angle = Math.abs(mintodegmap.get(minutes)-hourtodegmap.get(hour));
         double offset = (double)minutes/2;
         double ans = 0.0;
         // 2 cases here: (double)Math.abs(expected_angle+offset):(double)Math.abs(expected_angle-offset);
         if(mintodegmap.get(minutes)<=hourtodegmap.get(hour)){
           ans = (double)Math.abs(expected_angle+offset);
         }else{
            ans = (double)Math.abs(expected_angle-offset);
         }
         //check which one is gr8er
         //expected_angle or 360-expected_angle
         //use the smaller one ofc
         return Math.min(ans, 360-ans);
    
     }
}