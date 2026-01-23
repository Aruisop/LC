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
     public int widthOfBinaryTree(TreeNode root) {
       int maxwidth = 0;
       Queue<Pair<TreeNode,Integer>>q=new LinkedList<>();
       q.offer(new Pair<>(root,0));
       while(!q.isEmpty()){
          int qsize = q.size();
          int minind = q.peek().getValue();
          int start=0,end=0;
          for(int i=0;i<qsize;i++){
            Pair<TreeNode,Integer>pair=q.poll();
            TreeNode curr = pair.getKey();
            int curr_ind = pair.getValue()-minind;
            if(i==0) start = curr_ind;
            if(i==qsize-1) end = curr_ind;
            if(curr.left!=null) q.offer(new Pair<>(curr.left,2*curr_ind+1));
            if(curr.right!=null) q.offer(new Pair<>(curr.right,2*curr_ind+2));
            maxwidth = Math.max(maxwidth, end-start+1);
          }
        }
       return maxwidth;    
     }
}