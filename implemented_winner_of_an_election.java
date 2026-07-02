// Winner of an election
// Given a lowercase string array arr[]. Each element in the array represents a vote cast for a candidate. Return the name of the candidate who received the maximum number of votes and the count of votes he received. In case of a tie between two or more candidates, return the lexicographically smallest name.

// Note: Return an array of strings, the winning candidate name as the first element and the vote count as the second element (typecast the count to string).
// Examples :

// Input: arr[] = ["john", "johnny", "jackie", "johnny", "john", "jackie", "jamie", "jamie", "john", "johnny", "jamie", "johnny", "john"]
// Output: ["john", "4"]
// Explanation: "john" has 4 votes casted for him, but so does "johnny". "john" is lexicographically smaller, so we print "john" and the votes he received.
// Input: n = 3
// arr[] = ["andy", "blake", "clark"]
// Output: ["Andy", "1"]
// Explanation: All the candidates get 1 votes each. We print "andy" as it is lexicographically smaller.

// Constraints:
// 1 <= arr.size() <= 105
// 1 <= arr[i].size() <= 105

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
// TC: O(n)
// SC: O(n)
class Solution {
    public List<String> winner(List<String> arr) {
         // code here
         HashMap<String, Integer>hm=new HashMap<>();
         for(String ele:arr){
            hm.put(ele,hm.getOrDefault(ele,0)+1);
         }
         String fin = "";
         int max = Integer.MIN_VALUE;
         for(Map.Entry<String, Integer>entry:hm.entrySet()){
           String curr = entry.getKey();
           int freq = entry.getValue();
           if(freq>max){
               max=freq;
               fin = curr;
           }else if(max==freq && curr.compareTo(fin)<0){
               fin = curr;
           }
         }
         List<String>ans = new ArrayList<>();
         ans.add(fin);
         ans.add(Integer.toString(max));
         return ans;
    }
}
