/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
     public TreeNode sortedListToBST(ListNode head) {
             //TC:O(nlogn)
             //SC:O(logn) 
             if(head==null) return null;
             if(head.next==null)return new TreeNode(head.val);
             //slow and fast ptr to find middle of ll
             ListNode slow =head, prevslow =null, fast =head;
             //middle of ll becomes the root
             while(fast!=null && fast.next!=null){
                 prevslow = slow;
                 slow = slow.next;
                 fast = fast.next.next;
             }
             //make root of middle ll node
             TreeNode root = new TreeNode(slow.val);
             //disconnect the entire list prior to the middle node
             prevslow.next = null;
             //recursively build the left and right subtrees
             // -10 -3 0 5 9
             //  (l1)--m-(l2)
             //l1 starts from the head, therefore recursively build the left subtree from the head
             //l2 starts from one after the mid, so build the right subtree recursively using slow.next (mid.next)
             root.left = sortedListToBST(head);
             root.right = sortedListToBST(slow.next);
             return root;
     }
}