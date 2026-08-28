class Solution {
     private static boolean dfs(int index, boolean prev_flag, int freq[],char ans[],String s, String target){
         if(index==target.length()) return prev_flag;
         int targ_idx = target.charAt(index) - 'a';
         int start = prev_flag?0:targ_idx;
         for(int chr=start;chr<26;chr++){
             if(freq[chr]==0) continue;
             ans[index]=(char)(chr+'a');
             freq[chr]--;
             boolean new_flag = (prev_flag || chr>targ_idx);
             if(dfs(index+1,new_flag,freq,ans,s,target)) return true;
             freq[chr]++; 
         }
         return false;
     }
     public String lexGreaterPermutation(String s, String target) {
     //TC: O(26*n)
     //SC; O(n) 
     int n = s.length();
     char ans[]=new char[n];
     int freq[]=new int[26];
     for(char ch:s.toCharArray()){
        freq[ch-'a']++;
     }
     boolean check = dfs(0,false,freq,ans,s,target);
     return check?new String(ans):"";    
     }
}