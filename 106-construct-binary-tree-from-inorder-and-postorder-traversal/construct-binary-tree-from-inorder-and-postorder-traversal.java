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
     private static TreeNode constrTree(int[] inorder, int[] postorder,int inStart,int inEnd,int postStart,int postEnd){
         if(inStart>inEnd) return null;
         TreeNode root = new TreeNode(postorder[postEnd]);
         int i=0;
         for(i=inStart;i<=inEnd;i++){
            if(inorder[i]==root.val) break;
         }
         //i is at the posn where I can find the root
         //find the leftandright sizes
         int leftsize = i-inStart;
         //unused here
         int rightsize = inEnd-i;
         root.left = constrTree(inorder,postorder, inStart, i-1, postStart, postStart+leftsize-1);
         root.right = constrTree(inorder,postorder, i+1, inEnd, postStart+leftsize, postEnd-1);
         return root;
     }
     public TreeNode buildTree(int[] inorder, int[] postorder) {
      int n = inorder.length;
      int inStart = 0;
      int inEnd = n-1;
      int postStart = 0;
      int postEnd = n-1;
      return constrTree(inorder,postorder,inStart,inEnd,postStart,postEnd);
     }
}