class Solution {
     public int maximumLengthSubstring(String s) {
         //TC: O(n^3), brute force
         //SC: O(n)
         int n = s.length();
         int max = 0;
         for(int i=0;i<n;i++){
             for(int j=i;j<n;j++){
              String sub = s.substring(i,j+1);
              boolean flag = true;
              HashMap<Character, Integer>hm=new HashMap<>();
                 for(char ch:sub.toCharArray()){
                     hm.put(ch, hm.getOrDefault(ch,0)+1);
                     if(hm.get(ch)>2){
                         flag=false;
                         break;   
                         }
                 }
                 if(flag){
                  max = Math.max(max, sub.length());
                 }
             }
         }
         return max;    
      }
}