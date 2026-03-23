class Solution {
     public int longestConsecutive(int[] nums) {
      //TC: O(n)
      //SC: O(n)
      HashSet<Integer>hs=new HashSet<>();
      int longest = 0;
      for(int ele:nums) hs.add(ele);
      for(int ele:hs){
         if(!hs.contains(ele-1)){
             int curr = ele;
             int streak = 1;
             while(hs.contains(curr+1)){
                curr++;
                streak++;
             }
             longest = Math.max(longest, streak);
         }
       }
      return longest;      
     }
}