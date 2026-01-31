class Solution {
    public int characterReplacement(String s, int k) {
         HashMap<Character,Integer>hm=new HashMap<>();
         int l=0;
         int maxFreq = 0;
         int maxlen = 0;
         int n = s.length();
         for(int r=0;r<n;r++){
             char right = s.charAt(r);
             hm.put(right,hm.getOrDefault(right,0)+1);
             maxFreq = Math.max(maxFreq,hm.get(right));
             int windlen = r-l+1;
             if((windlen-maxFreq)>k){
                char left = s.charAt(l);
                hm.put(left,hm.get(left)-1);
                l++;
             }
           maxlen = Math.max(maxlen,r-l+1);   
         }
         return maxlen; 
    }  
}