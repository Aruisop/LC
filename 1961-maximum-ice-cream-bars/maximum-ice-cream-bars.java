class Solution {
     public int maxIceCream(int[] costs, int coins) {
         //counting sort approach
         //TC: O(n)
         //SC: O(n)
         HashMap<Integer,Integer>hm = new HashMap<>();
         int max = Integer.MIN_VALUE;
         for(int cost:costs){
            hm.put(cost,hm.getOrDefault(cost,0)+1);
            max = Math.max(max,cost);
         }
         //counting sort starts here
         //test each cost value, from 1 to the max cost
         int bars = 0;
         for(int i=1;i<=max;i++){
             if(!hm.containsKey(i)) continue;
             int ct = hm.get(i);
             int potential_bar = Math.min(ct,coins/i);
             bars+=potential_bar;
             coins-=potential_bar*i;
             if(coins<ct) continue;
         }
         return bars;
     }
}