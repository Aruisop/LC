// Online Java Compiler (Editor)
// Write and run Java online using this editor.
import java.util.*;
class SegmentTree{
    int n;
    int segTree[];
    public SegmentTree(int n){
        this.n=n;
        //use 4*n for better accomodation, 2*n works but 4*n safer 
        this.segTree=new int[4*n];
     }
    // index,0,n-1,nums
    void buildSegmentTree(int i, int l, int r,int nums[]){
         if(l==r){
           segTree[i]=nums[l]; //or nums[r]
           return;  
         }
        int mid = l+(r-l)/2;
        //left
        buildSegmentTree(2*i+1,l,mid,nums);
        //right
        buildSegmentTree(2*i+2,mid+1,r,nums);
        //root = left+right
        segTree[i] = segTree[2*i+1]+segTree[2*i+2];
    }
    
    void updateSegTree(int idx,int val,int i, int l, int r){
        if(l==r){
            segTree[i]=val;
            return;
        }
        //find mid to decide which branch to search ie left/right
        int mid = l+(r-l)/2;
        if(idx<=mid){
            //go left
            updateSegTree(idx,val,2*i+1,l,mid);
        }else{
            //go right
            updateSegTree(idx,val,2*i+2,mid+1,r);
        }
        segTree[i] = segTree[2*i+1]+segTree[2*i+2];
    }
    
    void displaySegTree(){
        System.out.println("SegTree");
        for(int ele:segTree){
            System.out.println(ele);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of arr/vect");
        int n = sc.nextInt();
        SegmentTree st = new SegmentTree(n);
        int nums[]=new int[n];
        System.out.println("Enter the elements of arr/vect");
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        //TC: O(logn) ::} for range query/update
        //SC: O(4*n) ~ O(n)  
        st.buildSegmentTree(0,0,n-1,nums);
        st.displaySegTree();
        st.updateSegTree(2,4,0,0,n-1);
        st.displaySegTree();
    }
}
