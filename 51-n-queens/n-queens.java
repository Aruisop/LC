class Solution {
     private static boolean isSafe(char board[][],int row,int col){
         int n = board.length;
         for(int i=0;i<n;i++){
           if(board[i][col]=='Q') return false;
         }
         for(int j=0;j<n;j++){
           if(board[row][j]=='Q') return false;
         }
         for(int i=row,j=col;i>=0 && j>=0;i--,j--){
           if(board[i][j]=='Q') return false;
         }
         for(int i=row,j=col;i>=0 && j<n;i--,j++){
           if(board[i][j]=='Q') return false;
         }
         return true;
     }
     private static void solve(char board[][],int row,int n,List<List<String>>ans){
       if(row==n){
         List<String>tmp=new ArrayList<>();
         for(char b[]:board){
           tmp.add(new String(b));
         }
         ans.add(new ArrayList<>(tmp));
         return;
         }
         for(int j=0;j<n;j++){
             if(isSafe(board,row,j)){
             board[row][j]='Q';
             solve(board,row+1,n,ans);
             board[row][j]='.';
             }
         }
     }
     public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans =new ArrayList<>();
       char board[][]=new char[n][n];
       for(int i=0;i<n;i++){
         for(int j=0;j<n;j++){
            board[i][j]='.';
         }
       }
       solve(board,0,n,ans);
       return ans;
     }
}