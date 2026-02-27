//COMPANY TAGS: Goldman Sachs

//BRUTE FORCE
//TC: O(n^2)
//SC: O(1) 

import java.util.*;

class CPIAWADIK{
  private static void countPairs(int arr[],int n, int k){
    int ct=0;
    for(int i=0;i<n;i++){
       for(int j=i+1;j<n;j++){
        if(Math.abs(arr[j]-arr[i])%k==0) ct++; 
       }
    }
    System.out.println(ct);
  }
  public static void main(String Args[]){
    int arr[] = {3,3,3};
    int k = 3;
    int n = arr.length;
    countPairs(arr,n,k);
  }
}

//OPTIMAL 
//TC: O(n)
//SC: O(k)

import java.util.*;

class CPIAWADIK{
  private static void countPairs(int arr[],int n, int k){
    //idea is to build up frequency of arr[i]%k
    //and then find the frq of occurence of arr[i]%k and add to ans
    //primary idea is ((arr[j]-arr[i])%k then arr[j]%k==arr[i]%k)
    HashMap<Integer,Integer>hm=new HashMap<>();
    int res=0;
    for(int i=0;i<n;i++){
      if(hm.contains(arr[i]%k)){
       res+=hm.get(arr[i]%k);  
      }
      hm.put(arr[i]%k,hm.getOrDefault(arr[i]%k,0)+1);
    }
    System.out.println(res);
  }
  public static void main(String Args[]){
    int arr[] = {3,3,3};
    int k = 3;
    int n = arr.length;
    countPairs(arr,n,k);
  }
}
