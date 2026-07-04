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
     private static int leftHt(TreeNode root){
        if(root==null) return 0; 
        return 1+leftHt(root.left);
     } 
     private static int rightHt(TreeNode root){
        if(root==null) return 0; 
        return 1+rightHt(root.right);
     }
     public int countNodes(TreeNode root) {
       //Optimal solution
      //TC: O( (log(n))^2 )
      //SC: O(n)        
      int left = leftHt(root);
      int right = rightHt(root);
      if(left==right){
        return (int)(Math.pow(2,left)-1);
      }
      return 1+countNodes(root.left)+countNodes(root.right);
     }
}