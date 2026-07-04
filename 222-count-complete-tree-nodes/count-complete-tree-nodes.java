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
     private static void inorder(TreeNode root,List<Integer>in){
         if(root==null) return;
         inorder(root.left,in);
         in.add(root.val);
         inorder(root.right,in);
     }
     public int countNodes(TreeNode root) {
         //Bforce: next ---> building optimal soln using this approach
         //TC: O(n) have to start somewhere
         //SC: O(n)
         List<Integer>in = new ArrayList<>();
         inorder(root,in);
         return in.size();
     }
}