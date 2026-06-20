class Solution {
     public String customSortString(String order, String s) {
     HashMap<Character,Integer>char_index_mapping = new HashMap<>();
     for(int i=0;i<order.length();i++){
        char_index_mapping.put(order.charAt(i),i);
     }
     StringBuilder posns_based_on_hm[] = new StringBuilder[order.length()];
     for(int i=0;i<order.length();i++){
        posns_based_on_hm[i]=new StringBuilder();
     }
     StringBuilder not_in_order = new StringBuilder();
     for(char ch:s.toCharArray()){
         if(char_index_mapping.containsKey(ch)){
            int idx = char_index_mapping.get(ch);
            posns_based_on_hm[idx].append(ch);
         }else{
            //these chars arent in the order str
            not_in_order.append(ch);
         }
     }
     StringBuilder ans = new StringBuilder();
     for(StringBuilder sb:posns_based_on_hm){
         ans.append(sb);
     }     
     ans.append(not_in_order);
     return ans.toString();
     }
}