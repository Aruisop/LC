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
     public boolean isSymmetric(TreeNode root) {
     Queue<TreeNode>q=new LinkedList<>();
     if(root==null) return true;
     q.offer(root.left);
     q.offer(root.right);    
     while(!q.isEmpty()){
        TreeNode l = q.poll();
        TreeNode r = q.poll();
        if(l==null && r==null) continue;
        if(l==null || r==null) return false;
        if(l.val!=r.val) return false;
        q.offer(l.left);
        q.offer(r.right);
        q.offer(l.right);
        q.offer(r.left);
      }
      return true;
     } 
}