class Solution {
     public int lengthOfLongestSubstring(String s) {
         HashMap<Character,Integer>hm=new HashMap<>();
         int l = 0;
         int r = 0;
         int max = 0;
         int n = s.length();
         while(r<n){
          if(hm.containsKey(s.charAt(r))){
            l=Math.max(l,hm.get(s.charAt(r))+1);
          } 
          max = Math.max(max,r-l+1);
          hm.put(s.charAt(r),r);
          r++;
         }
         return max;
     }
}