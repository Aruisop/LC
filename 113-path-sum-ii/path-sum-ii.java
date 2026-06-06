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
     private static void rec(TreeNode root, int targetSum,List<List<Integer>> ans,List<Integer>tmp){
         if(root==null) return;
         tmp.add(root.val);
         if(root.left==null && root.right==null && targetSum == root.val){
            ans.add(new ArrayList<>(tmp));
         }
         rec(root.left,  targetSum-root.val,ans,tmp);
         rec(root.right, targetSum-root.val,ans,tmp);
         tmp.remove(tmp.size()-1);
     }
     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
          //TC: O(n)
          //SC: O(n)   
          List<List<Integer>> ans = new ArrayList<>();
          rec(root,targetSum,ans,new ArrayList<>());
          return ans;
     }
}