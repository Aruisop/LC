class Solution {
     public String minWindow(String s, String t) {
       int m = s.length();
       int n = t.length();
       int ct=n;
       int l = 0;
       HashMap<Character,Integer>hm=new HashMap<>();
       for(char ch:t.toCharArray()){
        hm.put(ch,hm.getOrDefault(ch,0)+1);
       }
       int minwin=Integer.MAX_VALUE;
       int sti=0;
       for(int r=0;r<m;r++){
         char right = s.charAt(r);
         if(hm.containsKey(right) && hm.get(right)>0)ct--;
         hm.put(right,hm.getOrDefault(right,0)-1);
         while(ct==0){
           char left = s.charAt(l);
           int currwin = r-l+1;
           if(currwin<minwin){
            minwin=currwin;
            sti=l;
           }
           hm.put(left,hm.get(left)+1);
           if(hm.containsKey(left) && hm.get(left)>0) ct++;
            l++;
         }
       }   

       return minwin==Integer.MAX_VALUE?"":s.substring(sti,sti+minwin);
     }
}