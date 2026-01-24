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
     private static void getParentMap(HashMap<TreeNode,TreeNode>hm,TreeNode root){
         Queue<TreeNode>q=new LinkedList<>();
         q.offer(root);
         while(!q.isEmpty()){
          int qsize = q.size();
          for(int i=0;i<qsize;i++){
             TreeNode curr = q.poll();
             if(curr.left!=null){
                hm.put(curr.left,curr);
                q.offer(curr.left);
             }
              if(curr.right!=null){
                hm.put(curr.right,curr);
                q.offer(curr.right);
             }
          }  
         }
     } 
     private static List<Integer> bfsFromTarget(HashMap<TreeNode,TreeNode>hm, TreeNode target, int k, HashSet<TreeNode>vis){
        List<Integer>res=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(target);
        vis.add(target);
         while(!q.isEmpty() && k>0){
          int qsize = q.size();
          for(int i=0;i<qsize;i++){
            TreeNode curr = q.poll();
             if(curr.left!=null && !vis.contains(curr.left)){
                vis.add(curr.left);
                q.offer(curr.left);
             }
              if(curr.right!=null && !vis.contains(curr.right)){
                vis.add(curr.right);
                q.offer(curr.right);
             }
             //vis the parent, as now the tree is converted to graph
             if(hm.containsKey(curr) && !vis.contains(hm.get(curr))){
                vis.add(hm.get(curr));
                q.offer(hm.get(curr));
             }
          }
          k--;
         }
         while(!q.isEmpty()){
            res.add(q.poll().val);
         }
        return res;
     }
     public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
           HashMap<TreeNode,TreeNode>hm=new HashMap<>();
           if(root==null) return new ArrayList<>();
           getParentMap(hm,root);
           HashSet<TreeNode>vis=new HashSet<>();
           return bfsFromTarget(hm,target,k,vis);
     }
}