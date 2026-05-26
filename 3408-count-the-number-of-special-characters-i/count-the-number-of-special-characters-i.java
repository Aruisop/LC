class Solution {
     public int numberOfSpecialChars(String word) {
         HashMap<Character,Integer>hm=new HashMap<>();
         for(char ch:word.toCharArray()){
         hm.put(ch,hm.getOrDefault(ch,0)+1);
          }
          //store small letters in vis set
         HashSet<Character>vis = new HashSet<>();
         int ct = 0;
         for(char ch:word.toCharArray()){
          if(!vis.contains(ch) && hm.containsKey(Character.toUpperCase(ch)) && ch!=Character.toUpperCase(ch)){
           vis.add(ch);
           vis.add(Character.toUpperCase(ch));
           ct++; 
          }
         }
         return ct; 
     }
}