class Solution {
     public boolean isValidSudoku(char[][] board) {
      //This is Brute-Force, space un-optimised
      //Hash re-comp and StringBuild up push sc to O(n^2)
      //whereas the TC remains same at O(81) ~ O(1), for N*N O(N^2)
      HashSet<String>hs=new HashSet<>();
      for(int i=0;i<9;i++){
         for(int j=0;j<9;j++){
          char num = board[i][j];
          if(num=='.') continue;
          String row = new String(num+"in row"+i);
          String col = new String(num+"in col"+j);
          String thrxthrbox = new String(num+"in thrxthrbx"+i/3+j/3);
          if(hs.contains(row) || hs.contains(col) || hs.contains(thrxthrbox)) return false;
          hs.add(row);
          hs.add(col);
          hs.add(thrxthrbox);
         }
      }
      return true;
     }
}