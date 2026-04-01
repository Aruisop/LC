// /*
// class Node {
//     int data;
//     Node left, right;
//     Node(int x) {
//         data = x;
//         left = right = null;
//     }
// }
// */

// class Solution {
//      private static void inorder(Node root, ArrayList<Node>al){
//          if(root==null) return;
//          inorder(root.left, al);
//          al.add(root);
//          inorder(root.right, al);
//      }
//      public ArrayList<Node> findPreSuc(Node root, int key) {
//           // code here
//           // Unoptimal with TC: O(n)
//           // and SC: O(n)
//           if(root==null) return null;
//           ArrayList<Node>al=new ArrayList<>();
//           Node pred = null, succ =null;
//           inorder(root,al);
//           for(int i=0;i<al.size();i++){
//               if(al.get(i).data==key){
//                   if(i-1>=0) pred=al.get(i-1);
//                   if(i+1<al.size()) succ=al.get(i+1);
//               }else{
//                   if(al.get(i).data<key){
//                       pred = al.get(i);
//                   }else if(al.get(i).data>key){
//                       succ=al.get(i);
//                       break;
//                   }
//               }
//           }
//           ArrayList<Node>ans=new ArrayList<>();
//           ans.add(pred);
//           ans.add(succ);
//           return ans;
//          }
// }

// ----------------------BFORCE UP------------------------------------------------------

/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        //TC: Optimal: O(h)::O(logn) Unintuit
        //SC: O(1)
        Node pred = null,suc=null;
        ArrayList<Node>ans=new ArrayList<>();
        Node curr = root;
        while(curr!=null){
            if(curr.data>key){
              suc=curr;
              curr=curr.left;
            }else if(curr.data<key){
                pred = curr;
                curr = curr.right;
            }else{
                if(curr.left!=null){
                    Node temp = curr.left;
                    while(temp.right!=null) temp=temp.right;
                    pred = temp;
                }
                
                if(curr.right!=null){
                        Node temp= curr.right;
                        while(temp.left!=null) temp=temp.left;
                        suc = temp;
                    }
                break;
            }
        }
        ans.add(pred);
        ans.add(suc);
        return ans;
    }
}
