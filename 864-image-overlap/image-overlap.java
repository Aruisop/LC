class Solution {
     private static int translate_Img1_To_Img2(List<List<Integer>>al_img1,List<List<Integer>>al_img2){
         int ans =0;
         Map<List<Integer>,Integer>shifts = new HashMap<>();
         for(List<Integer> ele1:al_img1){
             for(List<Integer> ele2:al_img2){
               int r = ele2.get(0)-ele1.get(0);
               int c = ele2.get(1)-ele1.get(1);
               List<Integer>curr_shift = Arrays.asList(r,c);
               int ct = shifts.getOrDefault(curr_shift,0)+1;
               shifts.put(curr_shift,ct);
               ans = Math.max(ans,ct); 
             }
         }
         return ans;
     }
     public int largestOverlap(int[][] img1, int[][] img2) {
        //Bru-Force
        //TC: O(n^4)
        //SC: O(n^2)
       int n = img1.length;
       List<List<Integer>>al_img1=new ArrayList<>();
       for(int i=0;i<n;i++){
         for(int j=0;j<n;j++){
              if(img1[i][j]==1){
               al_img1.add(Arrays.asList(i,j)); 
              }
         }
       }
       System.out.println(al_img1);
       List<List<Integer>>al_img2=new ArrayList<>();
       for(int i=0;i<n;i++){
         for(int j=0;j<n;j++){
              if(img2[i][j]==1){
               al_img2.add(Arrays.asList(i,j)); 
              }
         }
       }
       System.out.println(al_img2);
       int ans = translate_Img1_To_Img2(al_img1,al_img2);
       return ans;
     }
}