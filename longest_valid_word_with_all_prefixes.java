/*
Q:
Longest Valid Word with All Prefixes

Given an array of strings words[], find the longest string such that every prefix of it is also present in words[]. If multiple strings have the same maximum length, return the lexicographically smallest one.

If no such string is found, return an empty string.

Examples:

Input: words[] = ["p", "pr", "pro", "probl", "problem", "pros", "process", "processor"]
Output: "pros" 
Explanation: "pros" is the longest word with all prefixes ("p", "pr", "pro", "pros") present.
Input: words[] = ["geeks", "gfg", "geeksforgeeks"]
Output: ""
Explanation: No valid strings for all their prefixes present in the words array.
Constraints:
1 <= words.size <= 1000
1 <= words[i].size <= 100

*/ 

// Approach 1:
// Use hashset
class Solution {
    public String longestValidWord(String[] words) {
         // code here
         //n--> number of words, l--> length of each word
         //TC: O(n*l^2)
         //SC: O(n*l)
         HashSet<String>hs=new HashSet<>();
         for(String word:words){
             hs.add(word);
         }
         String ans = "";
         for(String word:words){
             boolean flag = true;
             for(int i=1;i<=word.length();i++){
                 if(!hs.contains(word.substring(0,i))){
                     flag = false;
                     break;
                 }
             }
             if(flag){
                 if(word.length()>ans.length()){
                     ans = word;
                 }else if(word.length()==ans.length() && word.compareTo(ans)<0){
                     ans = word;
                 }
             }
         }
         return ans;
    }
}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------
// Approach 2
// use trie

class Trie{
    Trie child[]=new Trie[26];
    boolean end;
}


class Solution {
     private void insert(Trie root,String word){
       Trie curr = root;
       for(char ch:word.toCharArray()){
           if(curr.child[ch-'a']==null) curr.child[ch-'a']=new Trie();
           curr = curr.child[ch-'a'];
       }
       curr.end = true;
     }
     private boolean isValid(Trie root,String word){
         Trie curr = root;
         for(char ch:word.toCharArray()){
             curr = curr.child[ch-'a'];
             if(curr==null || !curr.end) return false;
         }
         return true;
     }
     public String longestValidWord(String[] words) {
         // code here 
         //TC: O(n*L)
         //SC:  O(1) aux space
         Trie root = new Trie();
         String ans = "";
         for(String word:words) insert(root,word);
         for(String word:words){
             if(isValid(root,word)){
                 if(word.length()>ans.length()) ans = word;
                 else if(word.length()==ans.length() && word.compareTo(ans)<0) ans=word;
             }
         }
         return ans;
     }
}

