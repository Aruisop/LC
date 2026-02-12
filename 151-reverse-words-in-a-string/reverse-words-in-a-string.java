class Solution {
     public String reverseWords(String s) {
     List<String>al=new ArrayList<>();
     s=s.trim();
     int n = s.length();
     int l=0;
     int r=0;
     while(r<n){
      if(s.charAt(r)==' '){
        al.add(s.substring(l,r));
        l=l+s.substring(l,r).length()+1;
        r=r+1;
      }
      //sp found after the prev space alr has been dealt with
      while(s.charAt(r)==' '){
        r++;
        l=r;
      }
      if(r==n-1)al.add(s.substring(l,r+1));
      r++;
     }
     Collections.reverse(al);
     StringBuilder sb = new StringBuilder();
     for(String str:al){
        sb.append(str).append(" ");
     }
     return sb.toString().trim();    
     } 
}