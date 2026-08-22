class Solution {
     public String frequencySort(String s) {
         //k is the number of unique chars
         //TC:  O(n+k*logk)
         //SC: O(n+k)  
         HashMap<Character, Integer>hm=new HashMap<>();
         for(char ch:s.toCharArray()){
             hm.put(ch, hm.getOrDefault(ch,0)+1);
         }
         //use pq to poll the highest freq char first.
         PriorityQueue<Map.Entry<Character, Integer>>pq=new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
         for(Map.Entry<Character,Integer>entry:hm.entrySet()){
            pq.offer(entry);
         }
         StringBuilder sb = new StringBuilder();
         while(!pq.isEmpty()){
             Map.Entry<Character,Integer> polled = pq.poll();
             char ch = polled.getKey();
             int freq = polled.getValue();
             for(int i=1;i<=freq;i++){
               sb.append(ch);
             }
         }
         return sb.toString();
     }
}