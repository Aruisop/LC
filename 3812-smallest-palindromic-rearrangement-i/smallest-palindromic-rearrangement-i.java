class Solution {
     public String smallestPalindrome(String s) {
         //TC: O(n*logn)
         //SC: O(n)
         //Algo is extract the left and right halves and then do the computation. 
         if(s.length()==0) return "";
         int n =s.length();
         int l = 0;
         int r = n-1;
         int mid = l+(r-l)/2;
         boolean isOdd = false;
         StringBuilder sb = new StringBuilder();
         if(n%2!=0){
            sb.append(s.substring(0,mid+1));
            sb.append("*");
            sb.append(s.substring(mid,n));
            isOdd = true;
         }else{
            sb = new StringBuilder(s);
         }
         //   for(char ele:sb.toString().toCharArray()){
          //     System.out.println(ele);
          //     System.out.println(isOdd);
          //   }
           int eval_len = sb.length();
          if(eval_len%2!=0 && isOdd){
             int l1 = 0;
             int r1 = eval_len-1;
             int mid1 = l1+(r1-l1)/2;
             //mid char is on *
             String first_half = sb.substring(0,mid1-1);
             char[] arr = first_half.toCharArray();
             Arrays.sort(arr);
             StringBuilder sb_first_half = new StringBuilder(new String(arr));
             //make a copy before reverse  
             StringBuilder reversed_sort = new StringBuilder(sb_first_half).reverse();
              StringBuilder final_ans = new StringBuilder();
             final_ans.append(sb_first_half);
             final_ans.append(s.charAt(mid));
             final_ans.append(reversed_sort);
             return final_ans.toString();
          }
          int l1 = 0;
          int r1 = eval_len-1;
          int mid1 = l1+(r1-l1)/2;
          String first_half = sb.substring(0,mid1+1);
          char[] arr = first_half.toCharArray();
          Arrays.sort(arr);
         StringBuilder sb_first_half = new StringBuilder(new String(arr));
         //make a copy before reverse  
         StringBuilder reversed_sort = new StringBuilder(sb_first_half).reverse();
         StringBuilder final_ans = new StringBuilder();
         final_ans.append(sb_first_half);
         final_ans.append(reversed_sort);
         return final_ans.toString();
     }
}