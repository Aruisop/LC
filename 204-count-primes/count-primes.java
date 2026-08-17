class Solution {
     public int countPrimes(int n) {
          //Pattern: Sieve of Eratosthenes
         //TC: O(n*log(log(n)))
         //SC: O(n)

         //mark all the numbers upto n as true  
         boolean isPrime[]=new boolean[n+1];
         for(int i=0;i<=n;i++){
            isPrime[i]=true;
         }
         //proceed to eliminate multiples from the list
         for(int i=2;i*i<=n;i++){
             if(isPrime[i]){
                 //make sure u are incrementing using i and not j++, because we are marking false for the multiples of i
                 for(int j=i*i;j<=n;j+=i){
                  isPrime[j]=false;
                 }
             }
         }
         int ct = 0;
         for(int i=2;i<n;i++){
            if(isPrime[i]) ct++; 
         }
         return ct;    
     }
}