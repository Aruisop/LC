class Solution {
     public int maxDepth(String s) {
         //TC: O(n)
         //SC: O(n)  
         Stack<Map<Character,Integer>>st=new Stack<>();
         int num_open_brackets = 0;
         int max = 0;
         for(char ch:s.toCharArray()){
              //reset
             if(st.isEmpty()){
                 num_open_brackets=0; 
             }  
             if(ch=='('){ 
                 num_open_brackets++;   
                 Map<Character, Integer>hm=new HashMap<>();
                 hm.put(ch, num_open_brackets);
                 st.push(hm);
             }else if(ch==')'){
                 if(!st.isEmpty()){
                 Map<Character,Integer>popped = st.pop();
                 max = Math.max(max,popped.get('('));
                 num_open_brackets--; 
                 }    
             }else{
                continue;
             }
         }
         return max;
     }
}