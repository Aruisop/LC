/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     private static int rec(TreeNode root, int maxsofar){
         int ct=0;
         if(root==null) return 0;
         if(root.val>=maxsofar){
            ct=1;
            maxsofar = root.val;
         }
         ct = ct+rec(root.left,maxsofar);
         ct = ct+rec(root.right,maxsofar);
         return ct;
     }
     public int goodNodes(TreeNode root) {
         //dfs approach
          return rec(root, Integer.MIN_VALUE);
     }
}