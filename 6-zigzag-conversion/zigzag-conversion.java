class Solution {
     public String convert(String s, int numRows) {
         //TC: O(numRows*n)
         //SC: O(numRows*n)
         StringBuilder ans = new StringBuilder();
         int n = s.length();
         char mat[][]=new char[numRows][n];
         int r = 0, c=0;
         boolean isGoingDown = true;
         if(numRows==1) return s;
         for(int i=0;i<n;i++){
           mat[r][c]=s.charAt(i);
           if(isGoingDown){
                 if(r==numRows-1){
                  isGoingDown=false;
                  r--;
                  c++;
                 }else{
                  r++;
                 }
           }else{
             if(r==0){
                isGoingDown=true;
                r++;
             }else{
                r--;
                c++;
             }
           }
         }
         for(int i=0;i<numRows;i++){
             for(int j=0;j<n;j++){
              if(mat[i][j]!='\0')  
              ans.append(mat[i][j]);
             }
         }
         return ans.toString();    
     }
}