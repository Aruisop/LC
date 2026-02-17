class Solution {
     public String largestOddNumber(String num) {
         int max = -1;
         int index = -1;
         int n = num.length();
         for(int i=0;i<n;i++){
             if((num.charAt(i)-'0')%2!=0){
                 index = i;
                 max=Math.max(index,max);
             }
         } 
         return num.substring(0,max+1);
     }
}