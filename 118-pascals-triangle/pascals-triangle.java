class Solution {
     private static void rec(int numRows,List<List<Integer>> ans){
         if(numRows==0) return;
         rec(numRows-1,ans);
         List<Integer>tmp=new ArrayList<>();
         for(int i=0;i<numRows;i++){
            tmp.add(1);
         }
         if(numRows>2){
             List<Integer>prev = ans.get(numRows-2);
             for(int i=1;i<numRows-1;i++){
                tmp.set(i,prev.get(i-1)+prev.get(i));
             }
         }
         ans.add(tmp);
     }
     public List<List<Integer>> generate(int numRows) {
         //TC:O(n^2)
         //SC: O(n) rec stack
         //unintuitive  
         List<List<Integer>> ans = new ArrayList<>();
         rec(numRows,ans);
         return ans;      
     } 
}