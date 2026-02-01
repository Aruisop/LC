class Solution {
     public int[] dailyTemperatures(int[] temperatures) {
         int n = temperatures.length; 
         int ans[]=new int[n];
         Stack<Integer>st=new Stack<>();
         for(int i=0;i<n;i++){
             int ct = 0; 
             while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                 int j = st.pop(); 
                 ans[j]=i-j;
             }
             st.push(i);
          }
         return ans;    
     }
}