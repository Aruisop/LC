class Solution {
     public boolean isAnagram(String s, String t) {
      //Easy..
      //TC: O(n+m) //worst case
      //SC: O(n+m)
      //the only optimisation is using a freq arr rather than
      //a hm, which is a space optimisation to O(26*2)~O(1)
      HashMap<Character,Integer>hm1=new HashMap<>();
      HashMap<Character,Integer>hm2=new HashMap<>();
      for(char c:s.toCharArray()){
        hm1.put(c,hm1.getOrDefault(c,0)+1);
      }
      for(char c:t.toCharArray()){
        hm2.put(c,hm2.getOrDefault(c,0)+1);
      }   
      return hm1.equals(hm2);
     }
}