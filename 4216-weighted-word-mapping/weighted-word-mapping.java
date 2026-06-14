class Solution {
     private static int findStringWt(String s,HashMap<Character,Integer>hm){
         int ans = 0;
         for(char ch:s.toCharArray()){
          ans+=hm.get(ch);
         }
         return ans;
     }
     public String mapWordWeights(String[] words, int[] weights) {
         //TC: O(no of chars in words arr)
         //SC: O(no of words in words arr)  
         //char to wt mapping
         HashMap<Character,Integer>hm=new HashMap<>();
         // int to char reversed mapping
         HashMap<Integer,Character>revAlph = new HashMap<>();
         for(int i=0;i<26;i++){
            revAlph.put(i,(char)('z'-i));
         }
         for(int i=0;i<26;i++){
            hm.put((char)('a'+i),weights[i]);
         }
         StringBuilder sb = new StringBuilder();
         for(String word:words){
            int wt = findStringWt(word,hm);
            int mappingint = wt%26;
            char mappedCh = revAlph.get(mappingint);
            sb.append(mappedCh);
         }
         return sb.toString();
     }
}