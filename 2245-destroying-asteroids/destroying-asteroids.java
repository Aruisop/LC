class Solution {
     public boolean asteroidsDestroyed(int mass, int[] asteroids) {
         //TC: O(nlogn)
         //SC: O(1)
         long presum = mass;
         Arrays.sort(asteroids);
         for(int val:asteroids){
           if(presum<val) return false;
           presum+=val;
         }
         return true;   
     }
}