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
     private static void swapnodevals(TreeNode root, int x, int y){
         if(root==null) return;
         if(root.val==x){
           root.val=y;
         }else if(root.val==y){
            root.val=x;
         }
         swapnodevals(root.left,x,y);
         swapnodevals(root.right,x,y);
     }
     private static void swap(TreeNode root,ArrayList<Integer>in, ArrayList<Integer>sorted){
         //[1,2,3]
         //[3,2,1]
         //[t,f,t]
         int n = in.size();
         int node1 = -1, node2=-1;
         boolean check[]=new boolean[n];
         for(int i=0;i<n;i++){
             //intval check because of java
             if(in.get(i).intValue()!=sorted.get(i).intValue()){
              check[i]=true;
             }
         }
         int arr[]=new int[2];
         int k=0;
         for(int i=0;i<check.length;i++){
             if(check[i]){
              arr[k++]=in.get(i);  
             }
         }
         int x = arr[0];
         int y = arr[1];
         //now in the bst wherever we see x swap with y
         //dont swap the node, but the val superficially.
         swapnodevals(root,x,y);
     }
     private static void inorder(TreeNode root,ArrayList<Integer>in){
         if(root==null) return;
         if(root.left!=null){
            inorder(root.left,in);
         }
         in.add(root.val);
         if(root.right!=null) inorder(root.right,in);
     }
     public void recoverTree(TreeNode root) {
         //bst prop: leftchild<root<rightchild
         //Brute-Force
         //TC: O(nlogn)
         //TC: O(n)
         ArrayList<Integer>in = new ArrayList<>();
         inorder(root,in);
         ArrayList<Integer>sorted = new ArrayList<>();
         for(int ele:in)sorted.add(ele);
         System.out.print(in);
         Collections.sort(sorted);
         System.out.print(sorted);
         swap(root,in,sorted);
     }
}