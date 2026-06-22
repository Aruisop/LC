class Solution {
     public int maxNumberOfBalloons(String text) {
      HashMap<Character,Integer>hm=new HashMap<>();
      for(char ch:text.toCharArray()){
        hm.put(ch,hm.getOrDefault(ch,0)+1);
      }
      int ans = 0;
      while(hm.getOrDefault('b',0)>=1 && hm.getOrDefault('a',0)>=1 && hm.getOrDefault('l',0)>=2 && hm.getOrDefault('o',0)>=2 && hm.getOrDefault('n',0)>=1){
         hm.put('b',hm.get('b')-1);
         hm.put('a',hm.get('a')-1);
         hm.put('l',hm.get('l')-2);
         hm.put('o',hm.get('o')-2);
         hm.put('n',hm.get('n')-1);
         ans++;
      }
      return ans;   
     }
}