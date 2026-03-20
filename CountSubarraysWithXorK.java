class Solution {
    public long subarrayXor(int arr[], int k) {
         // code here
         // TC: O(n^2)
         // SC: O(1)
         // int n = arr.length;
         // long ct = 0;
         // for(int i=0;i<n;i++){
         //     int xor = 0;
         //     for(int j=i;j<n;j++){
         //       xor = xor^arr[j];
         //       if(xor==k) ct++;
         //     }
         //  } 
         // return ct;
         // Brforce
// -------------------------------------------------------
         // Optimal
         // code here
         //TC: O(n)
         //SC: O(n)
         // wrong approach used prior was a 2 pass approach
         // in which precomp of prefix xors were done (correct)
         // but thought of using them for later (not right)
         // 1 pass is the right approach
         int n = arr.length;
         int xor = 0;
         long ct = 0;
         HashMap<Integer,Integer>hm=new HashMap<>();
         hm.put(0,1);
         for(int i=0;i<n;i++){
             //check for curr xor
             xor = xor^arr[i];
             if(hm.containsKey(xor^k)){
                 ct+=hm.get(xor^k);
             }
             hm.put(xor, hm.getOrDefault(xor,0)+1);
         }
         return ct;
     }
}
