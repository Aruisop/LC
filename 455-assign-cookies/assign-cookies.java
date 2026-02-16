class Solution {
     public int findContentChildren(int[] g, int[] s) {
          //max content children
          //greedy
          //sort g,s
         Arrays.sort(g);
         Arrays.sort(s);
         int l1=0;
         int l2=0;
         int m = g.length;
         int n = s.length;
         int ct = 0;
         while(l1<m && l2<n){
             if(g[l1]<=s[l2]){
                ct++;
                l1++;
                l2++;
             }else{
                 l2++;
             }
         }
         return ct;
     } 
}