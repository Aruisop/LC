class Solution {
     public int minimumDistance(int[] nums) {
         //TC: O(n)
         //SC: O(n)
         //idea is to find the occurences of no via the hashmap,
         //store all these occurences inside the hashmap, and then proceed
         HashMap<Integer,ArrayList<Integer>>hm=new HashMap<>();
         int n = nums.length;
         for(int i=0;i<n;i++){
             hm.computeIfAbsent(nums[i], k->new ArrayList<>()).add(i);
         }
         int min = Integer.MAX_VALUE;
         for(List<Integer>list:hm.values()){
             //continue if not possible to find 3 eles, in list
             //for a particular ele  
             if(list.size()<3) continue;
             //iterate thru the list 
             //the final ans just depends on the last and first index
             //related as dist: 2*(k-i); {mod arithmetic}    
             for(int i=0;i+2<list.size();i++){
                 int first = list.get(i);
                 int last  = list.get(i+2);
                 int dist  = 2*(last-first);
                 min = Math.min(min, dist);
             }
         }
         return min==Integer.MAX_VALUE?-1:min;
     }
}