class Solution {
     public int numberOfSubstrings(String s) {
         int l = 0;
         int n = s.length();
         HashMap<Character,Integer>hm=new HashMap<>();
         int ct=0;
         //n-r substrs is imp to remember, is invariant here if freq>0 for all chars
       for(int r=0;r<n;r++){
         char right = s.charAt(r);
         hm.put(right,hm.getOrDefault(right,0)+1);
         while(hm.getOrDefault('a',0)>0 && hm.getOrDefault('b',0)>0 && hm.getOrDefault('c',0)>0){
          ct+=n-r;
          char left = s.charAt(l);
          hm.put(left,hm.get(left)-1);
          l++;
         }
         }
       return ct;   
     }
}