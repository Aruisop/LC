class Solution {
     public boolean isPossibleDivide(int[] nums, int k) {
       //just like Hand of Straights LC 846
       TreeMap<Integer,Integer>tm=new TreeMap<>();
       for(int ele:nums){
        tm.put(ele,tm.getOrDefault(ele,0)+1);
       } 
       while(!tm.isEmpty()){
         int first = tm.firstKey();
         for(int i=0;i<k;i++){
            int curr = first + i;
            if(!tm.containsKey(curr)) return false;
            tm.put(curr,tm.get(curr)-1);
            if(tm.get(curr)==0) tm.remove(curr);
         }
       }
       return true;  
     }
}