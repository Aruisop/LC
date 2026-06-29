class Solution {
     private static boolean isSubstring(String pattern, String word){
         int pattern_len = pattern.length();
         int word_len = word.length();
         if(pattern_len>word_len) return false;
         if(pattern_len<=word_len){
           if(word.contains(pattern)) return true;
         }
         return false;
     }
     public int numOfStrings(String[] patterns, String word) {
             //TC: O(n*(len_of_each_pattern))
             //SC: O(1)
             int ct = 0;
             for(String pattern:patterns){
                 if(isSubstring(pattern,word)){
                     ct++;
                 }     
             }
        return ct;     
     }
}