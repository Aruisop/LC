class Solution {
     private static boolean dfs(int i, int j, int ind, String word, char[][] board,boolean vis[][]){
       int m = board.length;
       int n = board[0].length;
       int wordlen = word.length();
       if(ind == wordlen) return true;
       if(i<0 || j<0 || i>=m || j>=n || vis[i][j] || board[i][j]!=word.charAt(ind))return false; 
       vis[i][j] = true;
       boolean ans = dfs(i+1,j,ind+1,word,board,vis) || dfs(i,j+1,ind+1,word,board,vis) || dfs(i-1,j,ind+1,word,board,vis) || dfs(i,j-1,ind+1,word,board,vis);
       vis[i][j] = false;
       return ans;
     }
     public boolean exist(char[][] board, String word) {
       int m = board.length;
       int n = board[0].length;
       boolean vis[][]=new boolean[m][n];
       for(int i=0;i<m;i++){
         for(int j=0;j<n;j++){
            if(!vis[i][j] && dfs(i,j,0,word,board,vis)) return true;
         }
       }
       return false;   
     }
}