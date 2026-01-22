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
     public List<Integer> rightSideView(TreeNode root) {
        //space-optimized
      List<Integer>ans=new ArrayList<>();
      Queue<TreeNode>q=new LinkedList<>();
      if(root==null) return new ArrayList<>();
      q.offer(root);
      while(!q.isEmpty()){
         int qsize = q.size();
         List<Integer>tmp=new ArrayList<>();
         for(int i=0;i<qsize;i++){
            TreeNode curr = q.poll();
            tmp.add(curr.val);
            if(i == qsize-1) ans.add(tmp.get(i));
            if(curr.left!=null) q.offer(curr.left);
            if(curr.right!=null) q.offer(curr.right);
         }
      }
      return ans;    
     }
}