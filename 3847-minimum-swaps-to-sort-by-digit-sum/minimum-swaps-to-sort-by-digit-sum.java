class Solution {
     private static void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
     }
     private static int getSum(int num){
         int tmp = num;
         int sum = 0; 
         while(tmp!=0){
            sum+=tmp%10;
            tmp/=10;
         }
         return sum;
     }
     public int minSwaps(int[] nums) {
          int n = nums.length;
          Integer copy[] = new Integer[n];
          for(int i=0;i<n;i++){
            copy[i]=nums[i];
          }
          //custom sort
          Arrays.sort(copy, (a,b)->{
             int digSumA = getSum(a);
             int digSumB = getSum(b);
             if(digSumA!=digSumB) return Integer.compare(digSumA,digSumB);
             return Integer.compare(a,b);
          });
          HashMap<Integer,Integer>valToIdx = new HashMap<>();
          for(int i=0;i<n;i++){
            valToIdx.put(nums[i],i);
          }
             int swaps= 0;
             for(int i=0;i<n;i++){
               int copyEle = copy[i];
               int copyEleIndex = valToIdx.get(copyEle);
               if(nums[i]==copyEle) continue;
               swap(nums,copyEleIndex,i);
               valToIdx.put(copyEle,i);
               valToIdx.put(nums[copyEleIndex],copyEleIndex);
               swaps+=1;
             }
          return swaps;
     }
}