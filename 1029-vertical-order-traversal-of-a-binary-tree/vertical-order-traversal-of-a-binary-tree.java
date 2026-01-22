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

 class Pair{
     TreeNode node;
     int vertical;
     int level;
     public Pair(TreeNode node, int vertical, int level){
        this.node=node;
        this.vertical=vertical;
        this.level=level;
     }
 } 
 class Solution {
     public List<List<Integer>> verticalTraversal(TreeNode root) {
         TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>nodes =new TreeMap<>();
         Queue<Pair>q=new LinkedList<>();
         q.offer(new Pair(root,0,0));
         List<List<Integer>>ans = new ArrayList<>();
         while(!q.isEmpty()){
            Pair curr = q.poll();
            TreeNode node = curr.node;
            int x = curr.vertical;
            int y = curr.level;
            nodes.putIfAbsent(x,new TreeMap<>());
            nodes.get(x).putIfAbsent(y, new PriorityQueue<>());
            nodes.get(x).get(y).offer(node.val);
            //left
            if(node.left!=null) q.offer(new Pair(node.left,x-1,y+1));
            //right
            if(node.right!=null) q.offer(new Pair(node.right,x+1,y+1));
         }
         for(TreeMap<Integer,PriorityQueue<Integer>>yvals:nodes.values()){
             List<Integer>tmp=new ArrayList<>();
             for(PriorityQueue<Integer>pq:yvals.values()){
               while(!pq.isEmpty()){ 
               tmp.add(pq.poll());
               }
             }
             ans.add(new ArrayList<>(tmp));
         }
       return ans;    
     }
 }