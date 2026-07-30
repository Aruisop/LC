class Solution {
     public int minimumPushes(String word) {
        //TC: O(n)
        //SC: O(n)
         int start = 2;
         int ct = 0;
         HashMap<Integer,Integer>hm=new HashMap<>();
      for(int i=0;i<word.length();i++){
         if(start>9){
          start=2;
         }
         hm.put(start,hm.getOrDefault(start,0)+1);
         ct+=hm.get(start);
         start++;
      }
      return ct;     
     }
}