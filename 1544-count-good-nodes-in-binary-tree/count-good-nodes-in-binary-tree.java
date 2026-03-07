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
     private static int rec(TreeNode root, int maxSoFar){
        if(root==null) return 0;
        int goodnodes = (root.val>=maxSoFar)?1:0;
        maxSoFar = Math.max(maxSoFar,root.val);
        return goodnodes+rec(root.left,maxSoFar)+rec(root.right,maxSoFar);
     }
     public int goodNodes(TreeNode root) {
         //DFS Approach, is to count whether the branch leads to a good node ct or not
         //if so, then add 1 to ans
         //TC: O(n)
         //SC: O(logn){ht of bin tree}
          return rec(root,root.val);
     }
}