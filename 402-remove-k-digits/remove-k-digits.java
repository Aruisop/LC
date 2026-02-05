class Solution {
     public String removeKdigits(String num, int k) {
      StringBuilder ans = new StringBuilder();  
      StringBuilder finans = new StringBuilder();
      Stack<Integer>st=new Stack<>();
      int n = num.length();
      for(int i=0;i<n;i++){
         while(!st.isEmpty() && st.peek()>(num.charAt(i)-'0') && k>0){
         st.pop();
         k--;
         }
         st.push(num.charAt(i)-'0');
         }
          //ensure that if the string is already sorted by default
         //remove the top k eles 
         while(!st.isEmpty() && k>0){
            st.pop();
            k--;
         }
         //create the finans str
         while(!st.isEmpty()){
            ans.append(st.pop());
         }
         //reverse finans
         for(int i=ans.toString().length()-1;i>=0;i--){
            finans.append(ans.charAt(i));
         }
         
         int idx=0;
         while(idx<finans.toString().length() && finans.charAt(idx)=='0'){
            idx++;
         }  
         String res = finans.substring(idx);
         return res.length()==0?"0":res;
     }
}