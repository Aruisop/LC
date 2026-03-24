class MinStack {
     //Optimal 
     //TC: O(1) for each fn and n overall
     //SC: O(n)
     Stack<Integer>st;
     Stack<Integer>minst;
     public MinStack() {
      st = new Stack<>();
      minst = new Stack<>();   
     }
    
     public void push(int val) {
      st.push(val);
      if(minst.isEmpty() || val<=minst.peek()) minst.push(val);   
     }
    
     public void pop() {
         int val = st.pop();
         if(val==minst.peek()) minst.pop();
     }
    
     public int top() {
        return st.peek();
     }
     
     public int getMin() {
        return minst.peek();
     }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */