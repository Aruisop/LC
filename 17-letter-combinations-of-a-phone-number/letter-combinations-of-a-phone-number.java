class Solution {
     private static void rec(StringBuilder sb,List<String>ans,String digits,int ind,HashMap<Integer,String>hm){
         int n = digits.length();
         if(ind==n && sb.length()==n){
          ans.add(new String(sb.toString()));
          return;
         }
         for(int i=ind;i<n;i++){
             String str = hm.get(digits.charAt(i)-'0');
             for(int j=0;j<str.length();j++){
             sb.append(str.charAt(j));
             rec(sb,ans,digits,i+1,hm);
             sb.deleteCharAt(sb.length()-1);
             }
         }
     }
     public List<String> letterCombinations(String digits) {
        List<String>ans=new ArrayList<>();
        StringBuilder sb =new StringBuilder();
        HashMap<Integer,String>hm=new HashMap<>();
        hm.put(2,"abc");
        hm.put(3,"def");
        hm.put(4,"ghi");
        hm.put(5,"jkl");
        hm.put(6,"mno");
        hm.put(7,"pqrs");
        hm.put(8,"tuv");
        hm.put(9,"wxyz");
        rec(sb,ans,digits,0,hm);
        return ans;
     }
}