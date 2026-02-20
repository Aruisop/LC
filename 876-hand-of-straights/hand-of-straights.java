class Solution {
     public boolean isNStraightHand(int[] hand, int groupSize) {
      TreeMap<Integer,Integer>tm=new TreeMap<>();
      for(int ele:hand){
        tm.put(ele,tm.getOrDefault(ele,0)+1);
      }
      while(!tm.isEmpty()){
         int first = tm.firstKey();
         for(int i=0;i<groupSize;i++){
             int curr = first + i;
             if(!tm.containsKey(curr)) return false;
             tm.put(curr,tm.get(curr)-1);
             if(tm.get(curr)==0){
               tm.remove(curr);
             }
         }
      }
      return true;   
     }
}