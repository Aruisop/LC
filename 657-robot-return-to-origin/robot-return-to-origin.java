class Solution {
     public boolean judgeCircle(String moves) {
         //Initially used an entropy/total energy based approach
         //didnt work as the main idea is to work on the freq of chars
         //TC: O(2*n)
         //SC: O(n)
         HashMap<Character,Integer>hm=new HashMap<>();
         for(char c: moves.toCharArray()){
            hm.put(c, hm.getOrDefault(c,0)+1);
         }
         for(char c:moves.toCharArray()){
             if(c=='U'){
                 //find freq of U and the same exact freq of D must be pres
                 int uFreq = hm.get(c);
                 if(hm.containsKey('D')){
                 int dFreq = hm.get('D');
                 if(uFreq!=dFreq) return false;
                 }else return false; 
             }else if(c=='R'){
                 int rFreq = hm.get(c);
                  if(hm.containsKey('L')){
                   int lFreq = hm.get('L');
                   if(rFreq!=lFreq) return false;
                  }else return false; 
             }else if(c=='L'){
                 int lFreq = hm.get(c);
                 if(hm.containsKey('R')){
                 int rFreq = hm.get('R');
                 if(rFreq!=lFreq) return false;
                 }else return false; 
             }if(c=='D'){
                 int dFreq = hm.get(c);
                 if(hm.containsKey('U')){
                 int uFreq = hm.get('U');
                 if(uFreq!=dFreq) return false;
                 }else return false; 
             }
         }
         return true;
     }
}