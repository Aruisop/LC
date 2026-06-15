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
     private static int height(TreeNode root){
         if(root==null) return 0;
         return 1+Math.max(height(root.left),height(root.right));
     }
     private static boolean rec(TreeNode root){
         //null tree is by default a balanced bt
         if(root==null) return true;
         int leftht = height(root.left);
         int rightht = height(root.right);
         //the condn is true for only those cases where both the left and right 
         //subtrees are also valid, therefore test them as well
         return Math.abs(leftht-rightht)<=1 && rec(root.left) && rec(root.right);
     }
     public boolean isBalanced(TreeNode root) {
             //TC: O(n^2)---->skewed bt  O(n*logn)---->balanced bt
             //SC: O(n)---->skewed bt   O(logn)---->balanced bt
             return rec(root);
     }
}