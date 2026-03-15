/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
     private static TreeNode rec(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;
        if(p.val<root.val && q.val<root.val) return rec(root.left,p,q);
        if(p.val>root.val && q.val>root.val) return rec(root.right,p,q);
        return root;
     }
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //TC: O(n)
        //SC: O(logn), for skewed trees its O(n)
     return rec(root,p,q);     
     }
}