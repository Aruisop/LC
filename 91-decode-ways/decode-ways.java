class Solution {
     public int numDecodings(String s) {
     //imo the dp soln is more intuitive
     //rec+memo has pitfalls
     int n = s.length();
     int dp[]=new int[n+1];
     //if the end of the str is reached that is considered a valid way
     dp[n]=1;
     for(int i=n-1;i>=0;i--){
         //if the char is 0, we cant consider it as a single char, needs to be like 10/20
         if(s.charAt(i)=='0') dp[i]=0;
         else{
             //the no of ways depends on the prev res
             dp[i] = dp[i+1];
             //check for the >=10 to <=26 range
             if(i+1<n){
                 //find the number in question
                 int num = (s.charAt(i)-'0')*10+(s.charAt(i+1)-'0');
                 //now dp[i] can have the case of the prev dp[i+2] posn also
                 //when 2digs are taken like 12 then (i->1 and i+1->2, so we check the i+2th subproblem) 
                 if(num>=10 && num<=26){
                    dp[i]+=dp[i+2];
                 }
             }
         }
     }
     return dp[0];
     } 
}