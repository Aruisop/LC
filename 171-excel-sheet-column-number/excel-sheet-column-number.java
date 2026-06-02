class Solution {
     public int titleToNumber(String columnTitle) {
         //Idea is to treat n>1 strings as a combination of the alr available chars
         //+base-26 positions if n>1
         //TC: O(n)
         //SC: O(26) ~O(1)
         HashMap<Character, Integer>hm=new HashMap<>();
         int ct = 1;
         for(char ch='A';ch<='Z';ch++){
         hm.put(ch, ct);
         ct+=1;
         }
         int ans = 0;
         int n = columnTitle.length();
         if(n==1) hm.get(columnTitle.charAt(0));
         for(int i=0;i<n;i++){
            ans+=hm.get(columnTitle.charAt(i))*Math.pow(26,n-i-1);
         }
         return ans;
     }
}