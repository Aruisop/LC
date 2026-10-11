class SegmentTree{
     int n;
     int segTree[];
     public SegmentTree(int n){
      this.n = n;
      this.segTree=new int[4*n];
     }
     void createSegTree(int[] arr,int i, int l,int r){
         if(l==r){ 
           segTree[i]=arr[l]; //nums[r]
           return;
         }
         int mid = l+(r-l)/2;
         //left
         createSegTree(arr,2*i+1,l,mid);
         //right
         createSegTree(arr,2*i+2,mid+1,r);
         segTree[i] = segTree[2*i+1]^segTree[2*i+2];
     }
     //start and end and query indices
     int querySegTree( int arr[], int i,int l, int r, int start, int end){
         //3 cases
        
         //out of bounds
         if(l>end || r<start) return 0;

         //exact existence
         if(l>=start && r<=end) return segTree[i];

         //overlap
         int mid = l+(r-l)/2;
         return querySegTree(arr,2*i+1,l,mid,start,end) ^ querySegTree(arr,2*i+2,mid+1,r,start,end);
     }
}
class Solution {
     public int[] xorQueries(int[] arr, int[][] queries) {
         //Segment Tree
         //TC: O(n*logn)
         //SC: O(n)
         int n = arr.length;
         int qu_len = queries.length;
         SegmentTree st = new SegmentTree(n);
         int k = 0;
         int ans[]=new int[qu_len];
         //create the segTree arr
         st.createSegTree(arr,0,0,n-1);
         for(int ele:st.segTree){
            System.out.println(ele);
         }
         //iterate
         for(int q[]:queries){
           int start = q[0];
           int end = q[1];
           ans[k++]=st.querySegTree(arr,0,0,n-1,start,end);
         }
         return ans;
     }
}