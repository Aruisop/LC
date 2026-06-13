class Solution {
     private static boolean isValid(String s){
        if(s.length()>1 && s.charAt(0)=='0') return false;
        int num = Integer.parseInt(s);
        return (num>=0 && num<=255);
     }
     private static void rec(String s,int index,int parts,List<String>ans,List<String>curr){
         if(index==s.length() && parts==4){
             ans.add(String.join(".",curr));
            return;
         }
         if(parts==4) return;
         for(int part=1;part<=3;part++){
             if(index+part>s.length()) break;
             String test = s.substring(index,index+part);
             if(isValid(test)){
               curr.add(test);
               rec(s,index+part,parts+1,ans,curr);
               //b-track
               curr.remove(curr.size()-1);
             }
         }
     }
     public List<String> restoreIpAddresses(String s) {
         // TC: O(3^4 ~ 81) ~O(1)
         // SC: O(3^4 ~ 81) ~O(1)   
          List<String>ans = new ArrayList<>();
          List<String>curr = new ArrayList<>();
          rec(s,0,0,ans,curr);
          return ans;
     }
}