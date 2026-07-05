/*
Question

Rat in a Maze

Given a binary matrix maze[][] of size n × n containing values 0 and 1, find all possible paths for a rat to travel from the source cell (0, 0) to the destination cell (n - 1, n - 1). The rat can move in four directions: up(U), down(D), left(L), and right(R).

1 represents an open cell through which the rat can move.
0 represents a blocked cell that cannot be traversed.
The rat can move only through open cells and cannot visit the same cell more than once in a path. Return all valid paths as strings consisting of 'U', 'D', 'L', and 'R', representing the sequence of moves taken by the rat.

Note: Return the paths in lexicographically increasing order. If no valid path exists, return an empty list.

Constraints:
2 ≤ n ≤ 5
0 ≤ maze[i][j] ≤ 1

*/


class Solution {
     private static void rec(ArrayList<String>ans,int[][] maze,StringBuilder tmp,int i, int j,boolean vis[][]){
         int n = maze.length;
         if(i==n-1 && j==n-1){
             ans.add(tmp.toString());
             return;
         }
         vis[i][j]=true;
         if(i+1<n && !vis[i+1][j] && maze[i+1][j]==1){
             tmp.append("D");
             rec(ans,maze,tmp,i+1,j,vis);
             tmp.deleteCharAt(tmp.length()-1);
         }
         if(i-1>=0 && !vis[i-1][j] && maze[i-1][j]==1 ){
             tmp.append("U");
             rec(ans,maze,tmp,i-1,j,vis);
             tmp.deleteCharAt(tmp.length()-1);
         }
         
         if(j+1<n && !vis[i][j+1] && maze[i][j+1]==1){
             tmp.append("R");
             rec(ans,maze,tmp,i,j+1,vis);
             tmp.deleteCharAt(tmp.length()-1);
         }
         if(j-1>=0 && !vis[i][j-1] && maze[i][j-1]==1){
             tmp.append("L");
             rec(ans,maze,tmp,i,j-1,vis);
             tmp.deleteCharAt(tmp.length()-1);
         }
         vis[i][j]=false;
     }
     public ArrayList<String> ratInMaze(int[][] maze) {
         // code here
         //TC: O(4^(n*n))
         //SC: O(n*n) 
         ArrayList<String>ans = new ArrayList<>();
         int n = maze.length;
         boolean vis[][]=new boolean[n][n];
         if(maze[0][0]==0 || maze[n-1][n-1]==0) return new ArrayList<>(); 
         rec(ans,maze,new StringBuilder(),0,0,vis);
         //arrange the strings lexicographically
         Collections.sort(ans);
         return ans;
     }
}
