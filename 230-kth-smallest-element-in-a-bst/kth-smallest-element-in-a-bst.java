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
     private static void inorder(TreeNode root,List<Integer>res){
        if(root==null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
     }
     public int kthSmallest(TreeNode root, int k) {
        //TC: O(n)
        //SC: O(n)
        List<Integer>res=new ArrayList<>();
        inorder(root,res);
        //the k-1th posn gives the final ans
        return res.get(k-1);
     }
}