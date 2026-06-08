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
     private static void rec(TreeNode rootnode,HashMap<Integer, List<int[]>>hm){
         if(!hm.containsKey(rootnode.val)) return;
             if(hm.containsKey(rootnode.val)){
                     List<int[]>temp = hm.get(rootnode.val);
                     for(int[]t:temp){
                         int child = t[0];
                         int isLeft = t[1];
                         if(isLeft==1){
                         rootnode.left = new TreeNode(t[0]);
                         rec(rootnode.left,hm);
                         }else{
                         rootnode.right = new TreeNode(t[0]);
                         rec(rootnode.right,hm);
                         }
                     }
             }  
     }
     public TreeNode createBinaryTree(int[][] descriptions) {
         //TC: O(n^2) bforced, need a smarter ds over here
         //used a vis set to hopefully evade tle, but didnt work out
         //SC: O(n^2)
         //moved on to using a smarter hashmap based ds
         //TC: O(n)
         //SC: O(n)
             Set<Integer>parset = new HashSet<>();
             Set<Integer>childset = new HashSet<>();
             for(int d[]:descriptions){
                parset.add(d[0]);
                childset.add(d[1]);
             }
              //identify root and build up from that
             int root = -1;
             for(int ele:parset){
                 if(!childset.contains(ele)){
                    root = ele;
                    break;
                 }
             }
             TreeNode rootnode = new TreeNode(root);
             //using a more optimised ds ofc
             HashMap<Integer, List<int[]>>hm=new HashMap<>();
             for(int d[]:descriptions){
                 int par = d[0];
                 int child = d[1];
                 int isLeft = d[2];
                 hm.putIfAbsent(par, new ArrayList<>());
                 hm.get(par).add(new int[]{child,isLeft});
             }
             //rec construcn
             rec(rootnode,hm);
             return rootnode;
     }
}