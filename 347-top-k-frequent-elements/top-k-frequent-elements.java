class Solution {
     public int[] topKFrequent(int[] nums, int k) {
      HashMap<Integer,Integer>hm=new HashMap<>();
      for(int ele:nums){
        hm.put(ele,hm.getOrDefault(ele,0)+1);
      }
      PriorityQueue<Pair<Integer,Integer>>pq=new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
      HashSet<Integer>hs=new HashSet<>();
      for(int ele:nums){
        hs.add(ele);
      }
      //only unique
      for(int ele:hs){
         pq.offer(new Pair<>(ele,hm.get(ele)));   
      }
      List<Integer>ans = new ArrayList<>();
      while(k>0){
         Pair<Integer,Integer>pair = pq.poll();
         ans.add(pair.getKey());
         k--;
         }
         int finans[]=new int[ans.size()];
         for(int i=0;i<ans.size();i++){
            finans[i]=ans.get(i);
         }
         return finans;
     }
}