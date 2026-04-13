class Solution {
     public String multiply(String num1, String num2) {
         //TC: O(n1*n2)
         //SC: O(n1+n2) ~can be made O(1) minor optimizn
         int n1 = num1.length();
         int n2 = num2.length();
         if(num1.equals("0") || num2.equals("0")) return "0";
         int res[]=new int[n1+n2];
         for(int i=n1-1;i>=0;i--){
             for(int j=n2-1;j>=0;j--){
                int p1 =   i+j;
                int p2 =   i+j+1;
                int mul =  (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int sum =  mul+res[p2];
                res[p1] += sum/10;
                res[p2] = sum%10;
             }
         }
         //remove any trailing zeroes
         List<Integer>store = new ArrayList<>();
         int k = 0;
         while(k<res.length && res[k]==0){
            k++;
         }
         for(int i=k;i<res.length;i++){
            store.add(res[i]);
         }
         StringBuilder sb = new StringBuilder();
         for(int p:store){
           sb.append(p);
         }
         return sb.toString();    
     }
}