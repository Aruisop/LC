class Solution {
     private static int dist(int a, int b){
         if(a==26) return 0;
         int x1 = a/6; 
         int y1 = a%6;
         int x2 = b/6;
         int y2 = b%6;
         return Math.abs(x1-x2)+Math.abs(y1-y2);
     }
     private static int recmemo(int index, int f1, int f2, String word, int memo[][][]){
         if(index == word.length()) return 0;
         if(memo[index][f1][f2]!=-1) return memo[index][f1][f2];
         //once you find the rowmajor index, then the way of finding the dist is cell/no of cols
         //in the grid on rhs, there are 6 cols and 5 rows
         //rows: cell/no of cols, cols: cell%no of cols   
         int curr = word.charAt(index)-'A';
         //move either finger1 to the curr cell, and find cost assoc with that, then
         //go to next state in which f1 is at curr and f2 is normal
         // and vice-versa for f2 being moved to curr cell
         int f1move = dist(f1, curr) + recmemo(index+1, curr, f2, word, memo);
         int f2move = dist(f2, curr) + recmemo(index+1, f1, curr, word, memo);
         int mindist = Math.min(f1move, f2move);
         return memo[index][f1][f2]=mindist;
     }
     public int minimumDistance(String word) {
         //TC: O(n*27*27) ~O(n)
         //SC: O(n) 
         int n = word.length();
         int memo[][][]=new int[n][27][27];
         for(int i=0;i<n;i++){
          for(int j=0;j<27;j++){
             for(int k=0;k<27;k++){
               memo[i][j][k]=-1;            
             }
           }
         }
         return recmemo(0, 26, 26, word, memo);
     }
}