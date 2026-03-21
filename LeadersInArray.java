// BRUTE FORCE
//---------------------- 

// class Solution {
//     static ArrayList<Integer> leaders(int arr[]) {
//          // code here
//          //BRF: TC: O(n^2)
//          // SC: O(1) EXCLU RET ARRlist 
//           int n = arr.length;
//           ArrayList<Integer>ans = new ArrayList<>();
//           for(int i=0;i<n;i++){
//               for(int j=i+1;j<n;j++){
//                   if(arr[i]<arr[j]) break;
//                   else if(j==n-1 && arr[i]>=arr[j]) ans.add(arr[i]);
//               }
//               if(i==n-1) ans.add(arr[i]);
//           }
//           return ans;
//     }
// }




// SEMI OPTIMAL
// ---------------------

// class Solution {
//     static ArrayList<Integer> leaders(int arr[]) {
//          // code here
//          //SEMIOPTIMAL with Stack(My Appr): TC: O(n)
//          // SC: O(n) EXCLU RET ARRlist 
//          //maintain a monotonic decr stack  
//           int n = arr.length;
//           Stack<Integer>st=new Stack<>();
//           ArrayList<Integer>ans = new ArrayList<>();
//           for(int i=0;i<n;i++){
//               while(!st.isEmpty() && arr[i]>st.peek()){
//                   st.pop();
//               }
//               st.push(arr[i]);
//           }
//           while(!st.isEmpty()){
//               ans.add(st.pop());
//           }
//           Collections.reverse(ans);
//           return ans;
//     }
// }



// OPTIMAL
// ---------------------

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        //TC: O(n)
        //SC: O(1)
        //iterate backwards from n-1
        //n-1th ele is always included in ans
        //max from back
        int n = arr.length;
         ArrayList<Integer>ans = new ArrayList<>();
         int max = arr[n-1];
         ans.add(max);
         for(int i=n-2;i>=0;i--){
           if(arr[i]>=max){
               max = arr[i];
               ans.add(max);
           }   
         }
         //sort the al to get final ans
         Collections.reverse(ans);
         return ans;
    }
}
