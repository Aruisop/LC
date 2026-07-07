class Solution {
     public long sumAndMultiply(int n) {
         long x = 0;
         long sum = 0;
         if(n==0) return 0;
         StringBuilder sb = new StringBuilder();
         String s = Integer.toString(n);
         for(char c:s.toCharArray()){
            if(c!='0') sb.append(c);
         }
         String ans = sb.toString();
         x = Long.parseLong(ans);
         long tmp = x;
         while(tmp!=0){
          long rem = tmp%10;
          sum+=rem;
          tmp=tmp/10;
         }
         return x*sum;
     }
}