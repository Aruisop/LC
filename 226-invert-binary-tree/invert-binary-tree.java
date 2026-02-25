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
     public TreeNode invertTree(TreeNode root) {
          //left part becomes right and vice versa
          //no big brain reqd, rel. intuitive
          //TC:O(n) as each node is visited once and constant work of swapping nodes is done. 
          //SC: O(logn)---> avg bintree, worst case it becomes skewed so its O(n) space like a ll
          if(root==null) return null;
          TreeNode recLeft = invertTree(root.left);
          TreeNode recRight = invertTree(root.right);
          root.left = recRight;
          root.right = recLeft;
          return root;
     }
}