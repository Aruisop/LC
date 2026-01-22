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
             List<Integer> ans = new ArrayList<>();
             //null root
             if(root==null) return new ArrayList<>();
             //get the rightmost ele in lot
             List<List<Integer>>lot=new ArrayList<>();
             Queue<TreeNode>q=new LinkedList<>();
             q.offer(root);
             while(!q.isEmpty()){
              List<Integer>tmp=new ArrayList<>();
              int qsize = q.size();
              for(int i=0;i<qsize;i++){
                TreeNode curr = q.poll();
                tmp.add(curr.val);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
              }
              lot.add(new ArrayList<>(tmp));
             }
             //select rtmost vals and add to final ans
             for(List<Integer>al:lot){
                  ans.add(al.get(al.size()-1));
                 }
             return ans;
     }
}