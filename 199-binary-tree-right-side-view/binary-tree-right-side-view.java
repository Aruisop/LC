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
     private static void rec(TreeNode root, int depth, List<Integer>ans){
         if(root==null) return;
         //highly imp dry run for the rec soln  
         if(depth==ans.size()){
           ans.add(root.val);
         }
         rec(root.right,depth+1,ans);
         rec(root.left,depth+1,ans);
     }
     public List<Integer> rightSideView(TreeNode root) {
      //TC:O(n)
      //SC:O(logn) rec stack space is logarithmic (ht based)
      if(root==null) return new ArrayList<>();
      List<Integer>ans=new ArrayList<>();
      rec(root,0,ans);
      return ans;
     }
}