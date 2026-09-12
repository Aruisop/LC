class Solution {
     private static int ans = 0;
     private static void rec(int[] digits, int idx,boolean vis[],int num){
         int n = digits.length;
         if(idx==3){
          if(num%2==0) ans++;
          return;
         }
         for(int i=0;i<n;i++){
            if(vis[i]) continue;
            //prevent leading 0's to come to 100's place
            if(idx==0 && digits[i]==0) continue;
            //skip duplis, sorted in prior for same reason
            if(i>0 && !vis[i-1] && digits[i]==digits[i-1]) continue;
            vis[i]=true;
            rec(digits,idx+1,vis,num*10+digits[i]);
            vis[i]=false;
         }
     }
     public int totalNumbers(int[] digits) {
       ans=0;
       int n = digits.length;
       boolean vis[]=new boolean[n];
       //get the duplis (if any) together; for business logic
       Arrays.sort(digits);
       rec(digits,0,vis,0);
       return ans;
     }
}