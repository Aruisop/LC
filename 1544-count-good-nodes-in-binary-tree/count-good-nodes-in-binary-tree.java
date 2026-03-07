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
     public int goodNodes(TreeNode root) {
      //BFS Approach(More Intuit)
      //TC: O(n)
      //SC: O(n)
      Queue<Pair<TreeNode,Integer>>q=new LinkedList<>();
      q.offer(new Pair<>(root,root.val));
      int ct=0;
      while(!q.isEmpty()){
         Pair<TreeNode,Integer> curr = q.poll();
         TreeNode currRoot = curr.getKey();
         int maxSoFar = curr.getValue();
         if(currRoot.val>=maxSoFar) ct++;
         int max = Math.max(currRoot.val,maxSoFar);
         if(currRoot.left!=null) q.offer(new Pair<>(currRoot.left,max));
         if(currRoot.right!=null) q.offer(new Pair<>(currRoot.right,max));
      }
      return ct;    
     }
}