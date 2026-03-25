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
class Solution {
     private static List<Integer> revList( ArrayList<Integer>al, int k){
         List<Integer>kList=new ArrayList<>();
         List<Integer>notkList=new ArrayList<>();
         int n = al.size();
         //incase the k val>n, rest all is perfect
         k=k%n;
         for(int i=0;i<n;i++){
            if(i>=n-k) kList.add(al.get(i));
            else notkList.add(al.get(i));
         }
         List<Integer>ans=new ArrayList<>();
         for(int i=0;i<kList.size();i++) ans.add(kList.get(i));
         for(int i=0;i<notkList.size();i++) ans.add(notkList.get(i));
         return ans;
     }
     public ListNode rotateRight(ListNode head, int k) {
         //BFORCE
         //TC: O(n)
         //SC: O(n)
          if(head==null) return null;
         ArrayList<Integer>al=new ArrayList<>();
         ListNode temp = head;
         while(temp!=null){
            al.add(temp.val);
            temp=temp.next;
         }
         List<Integer>ans=new ArrayList<>();
         ans = revList(al,k);
         ListNode newHead = new ListNode(ans.get(0));
         ListNode t = newHead;
         for(int i=1;i<ans.size();i++){
          t.next = new ListNode(ans.get(i));
          t=t.next;
         }
         t.next=null;
         return newHead;   
     }
}