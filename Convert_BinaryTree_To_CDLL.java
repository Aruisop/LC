/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
     private static void inorder(Node root,List<Integer>in){
         if(root==null) return;
         inorder(root.left,in);
         in.add(root.data);
         inorder(root.right,in);
     }
     Node bTreeToCList(Node root) {
          // code here
          //TC: O(n)
          //SC: O(n)
         List<Integer>in = new ArrayList<>();
         if(root==null) return null;
         inorder(root,in);
         Node dummyHead =  new Node(-1);
         Node prev = dummyHead;
         Node lastNode = null;
         for(int ele:in){
             Node curr = new Node(ele);
             prev.right = curr;
             curr.left = prev;
             prev = curr;
             lastNode = curr;
         }
         //now attach the links properly
         lastNode.right = dummyHead.right;
         dummyHead.right.left = lastNode;
         //then detach the dummyHead, for increased safety;
         dummyHead.left=null;
         dummyHead.right=null;
         return lastNode.right;
     }
}
