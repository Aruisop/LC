/*

Ninja's training

A ninja has planned a n-day training schedule. Each day he has to perform one of three activities - running, stealth training, or fighting practice. The same activity cannot be done on two consecutive days and the ninja earns a specific number of merit points, based on the activity and the given day.

Given a n x 3-sized matrix, where matrix[i][0], matrix[i][1], and matrix[i][2], represent the merit points associated with running, stealth and fighting practice, on the (i+1)th day respectively. Return the maximum possible merit points that the ninja can earn.

Example 1
Input: matrix = [[10, 40, 70], [20, 50, 80], [30, 60, 90]]
Output: 210
Explanation:
Day 1: fighting practice = 70

Day 2: stealth training = 50

Day 3: fighting practice = 90

Total = 70 + 50 + 90 = 210

This gives the optimal points.


Example 2
Input: matrix = [[70, 40, 10], [180, 20, 5], [200, 60, 30]]
Output: 290
Explanation:

Day 1: running = 70

Day 2: stealth training = 20

Day 3: running = 200

Total = 70 + 20 + 200 = 290

This gives the optimal points.
*/ 

class Solution {
     private static int rec(int[][] matrix,int ind,int prev, int memo[][]){
             int n = matrix.length;
             if(ind==n){
             return 0;
             }
             if(memo[ind][prev+1]!=-1) return memo[ind][prev+1];   
             int maxcost = Integer.MIN_VALUE;
             for(int type=0;type<3;type++){
                 if(prev!=type){
                 int cost = matrix[ind][type]+rec(matrix,ind+1,type,memo);
                 maxcost = Math.max(maxcost,cost);
                 }  
             }
        return memo[ind][prev+1]=maxcost; 
     }
     public int ninjaTraining(int[][] matrix) {
         // TC; O(n)
         // SC: O(n)
         int n = matrix.length;
         int memo[][]=new int[n+1][4];
         for(int mem[]:memo){
             Arrays.fill(mem,-1);
           }
         return rec(matrix,0,-1,memo);
     }
}
