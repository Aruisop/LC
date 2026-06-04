class Solution {
     private static int ctWaves(int num, List<Integer>al){ 
         //exclude the first and last digs
         int temp2 = num;
         while(temp2!=0){
             int rem = temp2%10;
             al.add(rem);
             temp2 = temp2/10;
         }
         Collections.reverse(al);
         int n = al.size();
         int peakct = 0;
         int valleyct = 0;
         for(int i=0;i<n;i++){
            if(i==0 || i==n-1) continue;
            if(i-1>=0 && i+1<n && al.get(i-1)<al.get(i) && al.get(i)>al.get(i+1)) peakct++;
            if(i-1>=0 && i+1<n && al.get(i-1)>al.get(i) && al.get(i+1)>al.get(i)) valleyct++;
         }
         return peakct+valleyct;
     } 
     public int totalWaviness(int num1, int num2) {
         //Expected BrForce Approach:
         //TC: O((num2-num1+1)*(no of digs))
         //SC: O((no of digs))
         int sum = 0;
         for(int i=num1;i<=num2;i++){
             //new al for each new number
             List<Integer>al=new ArrayList<>();
             sum+=ctWaves(i, al);
         }
         return sum;    
     }
}