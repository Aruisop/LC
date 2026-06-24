class Solution {
     public List<String> addOperators(String num, int target) {
         //TC: O(n*4^n)
         //SC: O(n)   
          if(num==null) return new ArrayList<>();
          List<String> ans = new ArrayList<>();
          rec(0,"",num,target,0,0,ans);
          return ans; 
     }
     private static void rec(int ind, String path,String num, int target,long res_so_far,long prevNum,List<String> ans){
         if(ind==num.length()){
             if(res_so_far==target){
                ans.add(path);
                return;
             }
         }
         for(int j=ind;j<num.length();j++){
             if(j>ind && num.charAt(ind)=='0') break;
             long currNum = Long.parseLong(num.substring(ind,j+1));
             if(ind==0){
               rec(j+1,path+currNum,num,target,currNum,currNum,ans);
             }else{
                rec(j+1,path+"+"+currNum,num,target,res_so_far+currNum,currNum,ans);
                rec(j+1,path+"-"+currNum,num,target,res_so_far-currNum,-currNum,ans);
                rec(j+1,path+"*"+currNum,num,target,res_so_far-prevNum+prevNum*currNum,prevNum*currNum,ans);
             }
         }
     }
}