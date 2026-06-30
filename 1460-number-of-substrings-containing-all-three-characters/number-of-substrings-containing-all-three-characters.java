class Solution {
     public int numberOfSubstrings(String s) {
         //Optimal
         //TC: O(n)
         //SC: O(1)  
         int endA = -1;
         int endB = -1;
         int endC = -1;
         int min = Integer.MAX_VALUE;
         int n = s.length();
         int ans= 0;
         for(int i=0;i<n;i++){
             if(s.charAt(i)=='a'){
               endA = i;
             }else if(s.charAt(i)=='b'){
               endB = i; 
             }else{
               endC = i; 
             }
             min = Math.min(endA,Math.min(endA,Math.min(endB,endC)));
             if(endA>-1 && endB>-1 && endC>-1){
                ans+=min+1;
             }  
         }
        return ans;
     }
}