class Solution {
     public int numberOfSpecialChars(String word) {
         //TC: O(n)
         //SC: O(1) ~constant space because, at max only 26 chars can go into the hm
         //use a hm to track posn of the last occ of a sm char
         //and also use it to track the first occ of an upper char
         HashMap<Character,Integer>shm=new HashMap<>();
         HashMap<Character,Integer>uhm=new HashMap<>();
         int n = word.length();
         //shm has all the last occ of small chars
         for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(ch>='a' && ch<='z') shm.put(ch,i);
         }
         //uhm has all the first occ of large chars
          for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(ch>='A' && ch<='Z' && !uhm.containsKey(ch)) uhm.put(ch,i);
            else continue;
         }
         HashSet<Character>small = new HashSet<>();
         //now just compare the indices present in both maps
         for(char ch:word.toCharArray()){
            if(ch>='a' && ch<='z') small.add(ch);
         }
         int ct = 0;
         for(char ch:small){
             char up = (char)(ch-32);
             if(shm.containsKey(ch)){
                 int smind = shm.get(ch);
                 int uind = -1;
                 if(uhm.containsKey(up)) uind = uhm.get(up);
                 if(smind<=uind) ct++;
              }
         }
         return ct;
     }
}