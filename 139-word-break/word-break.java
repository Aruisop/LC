 class TrieNode{
    TrieNode children[]=new TrieNode[26];
    boolean eow=false;
 }
 class Solution {
     //insert the word from the worddict into the trie
     private static void insert(TrieNode root, String word){
             TrieNode curr=root;
             for(char ch:word.toCharArray()){
                 int idx = ch-'a';
                 //create the trienode in case it doesnt exist
                 if(curr.children[idx]==null) curr.children[idx] = new TrieNode();
                 //move forward
                 curr = curr.children[idx];    
             }
             //mark the end of word as true
             curr.eow=true; 
     }
     public boolean wordBreak(String s, List<String> wordDict) {
      //very intuitive trie+dp
      int n = s.length();
      TrieNode root = new TrieNode();
      //insert the words into the trie
      for(String word:wordDict){
        insert(root,word);
      }
      boolean dp[]=new boolean[n+1];
      //empty str can always be segmented(prefixed)
      dp[0]=true;
      for(int i=0;i<n;i++){
          TrieNode curr = root; 
         //skip over all the indices which cant be segmented
         if(!dp[i]) continue;
         for(int j=i;j<n;j++){
           if(curr.children[s.charAt(j)-'a']==null) break;
           curr=curr.children[s.charAt(j)-'a'];
           //if the word is found in the trie, the j+1 position in the dp is marked true
           //why?---->ie the position after the jth index can be segmented as its present in
           //the tree
           if(curr.eow) dp[j+1]=true; 
         }
      }
      return dp[n];
     }
 }