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
     private static int ans_ct = 0;
     private static int recursiveSum(TreeNode root){
        if(root.left==null && root.right==null) return root.val;
        int left = 0, right = 0;
        if(root.left!=null) left = recursiveSum(root.left);
        if(root.right!=null) right = recursiveSum(root.right);
        return root.val+left+right;
      }
      private static int countNodesLilBro(TreeNode root){
         if(root.left==null && root.right==null && root!=null) return 1;
         int left =0;
         int right =0;
         if(root.left!=null) left = countNodesLilBro(root.left);
         if(root.right!=null) right = countNodesLilBro(root.right);
         return 1+left+right;
      }
      private static void countNodesEqualToAverageOfSubtree(TreeNode root){
          int sumTillBelow = recursiveSum(root);
          int nodesCt = countNodesLilBro(root);
          int avgSum = sumTillBelow/nodesCt;
          //tried to handle leaf nodes stupidly :(
            //if(root.left==null && root.right!=null) avgSum = root.val;
          if(avgSum==root.val) ans_ct++;
          if(root.left!=null) countNodesEqualToAverageOfSubtree(root.left);
          if(root.right!=null) countNodesEqualToAverageOfSubtree(root.right);
      }
     public int averageOfSubtree(TreeNode root) {
         //TC: O(n)
         //SC: O(n) skewed tree
         ans_ct = 0;
         countNodesEqualToAverageOfSubtree(root);
         return ans_ct;
     }
}