//TC: O(n)----> Inorder traversal visits exactly one node at a time
//SC: O(logN)/O(n) ----> In case of a skewed tree the sc will be O(n), in ht-balanced it is logarithmic
/*
class Node {
    int data;
    Node left, right;

    Node() {
        this.data = 0;
        this.left = this.right = null;
    }

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
*/
class Solution {
     Node prev = null;
     Node head = null;
     private void inorder(Node curr){
         if(curr.left!=null) inorder(curr.left);
         if(prev==null){
           head=curr;  
          }else{
               prev.right = curr;
               curr.left=prev;
          }
          prev=curr;
         if(curr.right!=null) inorder(curr.right);
     }
     Node bToDLL(Node root) {
         // code here
         if(root==null) return null;
         inorder(root);
         return head;
     }
}
