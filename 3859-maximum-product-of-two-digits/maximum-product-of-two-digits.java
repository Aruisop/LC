class Solution {
     public int maxProduct(int n) {
         //Brute-Force 
         //TC: O(n^2)
         //SC: O(n)    
         List<Integer>al=new ArrayList<>();
         int temp=n;
         while(temp!=0){
          int rem = temp%10;
          al.add(rem);
          temp/=10;
         }
         int max = Integer.MIN_VALUE;
         Collections.reverse(al);
         for(int i=0;i<al.size();i++){
             int prod = 0;
             for(int j=i+1;j<al.size();j++){
                 prod = al.get(i)*al.get(j);
                 max = Math.max(max,prod);
             }
         }
         return max;      
     }
}