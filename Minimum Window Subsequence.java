// LC 727: Minimum Window Subsequence
// TC: O(m*n)
// SC: O(1)

class Solution {
    public String minWindow(String s1, String s2) {
         // code here
         int m = s1.length();
         int n = s2.length();
         int min = Integer.MAX_VALUE;
         String ans = "";
         int j=0;
         for(int i=0;i<m;i++){
            if(s1.charAt(i)==s2.charAt(j)){
                 j++;
                 if(j==n){
                 int end = i+1;
                 j--;
                 while(j>=0){
                     if(s1.charAt(i)==s2.charAt(j)) j--;
                     i--;
                 }
                 i++;
                 j++;
                 if(end-i<min){
                     min = end - i;
                     ans = s1.substring(i,end);
                 }
                 }
            }   
         }
         return ans;
    }
}
