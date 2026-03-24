class Solution {
     public boolean checkInclusion(String s1, String s2) {
      HashMap<Character, Integer>hm1=new HashMap<>();
      for(char ch: s1.toCharArray()){
        hm1.put(ch, hm1.getOrDefault(ch,0)+1);
      }
      int l = 0;
      HashMap<Character, Integer>hm2 = new HashMap<>();
      int k = s1.length();
      int n = s2.length();
      for(int r=0;r<n;r++){
         char right = s2.charAt(r);
         hm2.put(right, hm2.getOrDefault(right,0)+1);
         //if the size on the win for the s2 str exceeds the s1 size
         if(r-l+1>k){
            char left = s2.charAt(l);
            //remove the left char from hm2s entries
            hm2.put(left, hm2.get(left)-1);
            if(hm2.get(left)==0) hm2.remove(left);
            l++;
         }
         //now if the winsize becomes the same as and the 2 hashmaps are equal
         if(r-l+1==k && hm1.equals(hm2)){
            return true;
         }
      }
      return false;   
     }
}