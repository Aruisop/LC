class Solution {
     private static boolean isPalin(String s){
       int n = s.length();
       int l = 0;
       int r = n-1;
       while(l<=r){
        if(s.charAt(l)!=s.charAt(r)) return false;
        l++;
        r--;
       }
       return true;
     }
     private static void rec(String s,int ind,List<List<String>> ans,List<String>tmp){
         int n = s.length();
         if(ind>=n){
             ans.add(new ArrayList<>(tmp));
             return;
         }
         for(int j=ind;j<n;j++){
            String test = s.substring(ind,j+1);
            if(isPalin(test)){
             //recurse only if it is a palind
             tmp.add(test);
              rec(s,j+1,ans,tmp);
             //btrack
             if(tmp.size()>0)tmp.remove(tmp.size()-1);
             }
         }
     }
     public List<List<String>> partition(String s) {
          //TC: O(n^2 * 2^n)
          //SC: O(n * 2^n)
          List<List<String>> ans  = new ArrayList<>();
          List<String>tmp = new ArrayList<>();
          rec(s,0,ans,tmp);
          return ans;
     }
}