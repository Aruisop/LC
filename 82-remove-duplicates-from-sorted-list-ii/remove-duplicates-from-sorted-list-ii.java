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
     public ListNode deleteDuplicates(ListNode head) {
         //Sheer Brute-Force 
         //TC: O(n)
         //SC: O(n)
         ListNode temp = head;
         if(head == null) return null;
         ArrayList<Integer>al=new ArrayList<>();
         while(temp!=null){
             al.add(temp.val);
             temp = temp.next;
         }
         HashMap<Integer,Integer>hm=new HashMap<>();
         int n = al.size();
         for(int i=0;i<n;i++){
            hm.put(al.get(i),hm.getOrDefault(al.get(i),0)+1);
         }
         if(hm.size()==1 && hm.get(al.get(0))>1) return null;
         else if(hm.size()==1 && hm.get(al.get(0))==1) return new ListNode(al.get(0));
         List<Integer>ans = new ArrayList<>();
         for(int ele:al){
            if(hm.get(ele)==1) ans.add(ele); 
         }
         if(ans.size()==0) return null;
         ListNode finhead = new ListNode(ans.get(0));
         ListNode fintemp = finhead;
         for(int i=1;i<ans.size();i++){
         ListNode nextNode = new ListNode(ans.get(i));
         fintemp.next = nextNode;
         fintemp = fintemp.next;
         }
         return finhead;
     }
}