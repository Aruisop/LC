class Solution {
     public List<Integer> partitionLabels(String s) {
          //TC: O(n)
          //SC: O(n) can be improved to O(26) using a freq store, but thats a minor optimzn
          List<Integer> ans = new ArrayList<>();
          int n = s.length();
          HashMap<Character,Integer>hm=new HashMap<>();
          //find the last index occ of the char, this is imp
          for(int i=0;i<n;i++){
            hm.put(s.charAt(i),i);
          }
          //logic is simple 2 ptrs
          int i = 0;
          int j = 0;
          while(i<n){
             int end = hm.get(s.charAt(i));
             while(j<end){
              end = Math.max(end,hm.get(s.charAt(j)));
              j++;
             }
             ans.add(j-i+1);
             //move to the next char once j reaches the end char
             i=j+1;
          }
          return ans;
     }
}