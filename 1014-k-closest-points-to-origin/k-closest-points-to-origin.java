class Solution {
     public int[][] kClosest(int[][] points, int k) { 
      PriorityQueue<double[]>pq=new PriorityQueue<>((a,b)->Double.compare(a[2],b[2]));
      for(int point[]:points){
          int xi = point[0];
          int yi = point[1];
          double dist = Math.sqrt(Math.pow(xi,2)+Math.pow(yi,2));
          pq.offer(new double[]{xi,yi,dist});
      }
      int ans[][]=new int[k][2];
      int store = k;
      while(!pq.isEmpty() && k!=0){
        double poll[]=pq.poll();
        double xi = poll[0];
        double yi = poll[1];
        k--;
        ans[k][0]=(int)xi;
        ans[k][1]=(int)yi;
      }
      return ans;    
     }
}