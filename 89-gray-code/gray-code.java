class Solution {
     public List<Integer> grayCode(int n) {
         //Bforce
         //TC: O(n^2) 
         //SC: O(n)
         List<Integer>curr = new ArrayList<>();
         curr.add(0);
         for(int i=0;i<n;i++){
             List<Integer>next  = new ArrayList<>();
             for(int ele:curr){
              next.add(ele);
              }
              int add = 1<<i;
             for(int j=curr.size()-1;j>=0;j--){
               next.add(curr.get(j)+add); 
             }
             curr = next; 
          }
         return curr;  
     }
}