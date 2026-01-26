 class TrieNode{
    TrieNode left;
    TrieNode right;
 }
 class Solution {
     private static void insert(TrieNode root,int x){
         TrieNode curr = root;
         for(int i = 31;i>=0;i--){
         int ith_bit = (x>>i) & 1;
         if(ith_bit==1){
            if(curr.right==null) curr.right = new TrieNode();
            curr = curr.right;
         }else{
            if(curr.left==null) curr.left = new TrieNode();
            curr = curr.left;
         }
         }
     }
     private static int getMaxXor(TrieNode root,int ele){
         TrieNode curr = root;
         int res = 0;
         for(int i = 31;i>=0;i--){
         int ith_bit = (ele>>i) & 1;
         if(ith_bit==1){
             if(curr.left!=null){
              res+=Math.pow(2,i);
              curr=curr.left;
             }else curr = curr.right;
             }else{
                if(curr.right!=null){
                res+=Math.pow(2,i);
                curr=curr.right;
                }else curr = curr.left;
              }
         }
         return res;
     }
     public int findMaximumXOR(int[] nums) {
           TrieNode root = new TrieNode();
           int max = 0;
           for(int x:nums){
            insert(root,x);
           }
           for(int ele:nums){
            max = Math.max(max,getMaxXor(root,ele));
           }
           return max;
     }
 }