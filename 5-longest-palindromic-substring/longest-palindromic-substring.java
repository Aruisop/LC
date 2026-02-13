class Solution {
     private static int[] expand(int l,int r,String s){
         int n =s.length();
         while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
         }
         //while returning, ensure that l+1 and r-1 is returned
         //this is becuase the l and r ptrs are 1 behind and 1 infront resp after
         //the loop breaks.
         return new int[]{l+1,r-1};
     }
     public String longestPalindrome(String s) {
         int n = s.length();
         int maxStart=0;
         int maxEnd=0; 
         //expansion logic, rest all approaches are non-intuitive/formula based
         for(int i=0;i<n;i++){
             //for an odd substr
             int odd[]=expand(i,i,s);
             if(odd[1]-odd[0]>maxEnd-maxStart){
              maxStart = odd[0];
              maxEnd = odd[1];
             }
             //for even substr
             int even[]=expand(i,i+1,s);
             if(even[1]-even[0]>maxEnd-maxStart){
                 maxStart = even[0];
                 maxEnd = even[1];
             }    
         }
         return s.substring(maxStart,maxEnd+1);
     } 
}