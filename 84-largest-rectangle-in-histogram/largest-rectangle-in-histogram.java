class Solution {
     public int largestRectangleArea(int[] heights) {
         int n = heights.length;
         int lse[]=new int[n];  
         int rse[]=new int[n];
         Arrays.fill(lse,0);
         Arrays.fill(rse,n-1);
         if(heights.length==1) return heights[0];
         Stack<Integer>st1=new Stack<>();
         Stack<Integer>st2=new Stack<>();
         //monot incr stack
         for(int i=0;i<n;i++){
         while(!st1.isEmpty() && heights[st1.peek()]>=heights[i]){
            st1.pop();
         }
         if(!st1.isEmpty()) lse[i] = st1.peek()+1;
         st1.push(i);
         }
         for(int i=n-1;i>=0;i--){
         while(!st2.isEmpty() && heights[st2.peek()]>=heights[i]){
            st2.pop();
         }
         if(!st2.isEmpty()) rse[i] = st2.peek()-1;
         st2.push(i);
         }
         int maxArea=0;
         for(int i=0;i<n;i++){
            maxArea = Math.max(maxArea,(rse[i]-lse[i]+1)*heights[i]); 
         }
         return maxArea;   
     }
}