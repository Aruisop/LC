//the code below works for all cases in which f has unique values, for duplicate values in f, there are 2 seperate Huffman Trees that can be evaluated and either one is correct.
//the solution below follows the guidelines stated above.

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------

//TC: O(n*log(n))
//SC: O(n)


// For huffman_tree buildup
class HuffMan_Node{
         int freq;
         HuffMan_Node left,right;
         public HuffMan_Node(int freq){
             this.freq = freq;
         }
     }
class Solution {
     private static void dfs(HuffMan_Node root,String code,ArrayList<String> ans){
         if(root==null) return;
         if(root.left==null && root.right==null){
             ans.add(new String(code));
             return;
         }
         dfs(root.left,code+"0",ans);
         dfs(root.right,code+"1",ans);
     }
     public ArrayList<String> huffmanCodes(String s, int f[]) {
          // Code here
          ArrayList<String> ans = new ArrayList<>();
        //   HuffMan_Node root = new HuffMan_Node();
          PriorityQueue<HuffMan_Node>pq=new PriorityQueue<>((a,b)->(a.freq-b.freq));
          for(int freq:f){
              pq.offer(new HuffMan_Node(freq));
          }
          while(pq.size()>1){
              HuffMan_Node left = pq.poll();
              HuffMan_Node right = pq.poll();
              HuffMan_Node parent = new HuffMan_Node(left.freq+right.freq);
              parent.left = left;
              parent.right = right;
              pq.offer(parent);
          }
          HuffMan_Node root = pq.poll();
          dfs(root,"",ans);
          return ans;
     }
}
