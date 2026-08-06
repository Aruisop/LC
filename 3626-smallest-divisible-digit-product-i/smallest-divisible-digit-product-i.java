class Solution {
     private static boolean isDigProdEqt(int num, int t){
         int temp = num;
         List<Integer>tmp=new ArrayList<>();
         while(temp!=0){
             int rem = temp%10;
             tmp.add(rem);
             temp=temp/10;
         }
             int prod = 1;
         for(int ele:tmp){
              prod*=ele;
         }
         return (prod%t==0);  
     } 
     public int smallestNumber(int n, int t) {
         int ans = 0;
         int min = Integer.MAX_VALUE;
         //Brute-Force
         //constraint
         for(int i=n;i<=100;i++){
             if(isDigProdEqt(i,t)){
               ans = i;
               min = Math.min(min,ans);
             }
         }
         return min;
     } 
}