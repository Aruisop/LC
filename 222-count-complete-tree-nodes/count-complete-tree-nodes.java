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
     private static int rec(TreeNode root){
      if(root==null) return 0;
      int left = 0;
      int right = 0;
      if(root.left!=null) left = rec(root.left);
      if(root.right!=null) right = rec(root.right);
      return 1+left+right;
     } 
     public int countNodes(TreeNode root) {
        return rec(root);
     }
}