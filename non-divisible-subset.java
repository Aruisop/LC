/*
Given a set of distinct integers, print the size of a maximal subset of S where the sum of any 2 numbers in S' is not evenly divisible by k.

Example

S = [19, 10, 12, 10, 24, 25, 22]
k = 4

One of the arrays that can be created is S'[0] = [10, 12, 25].
Another is S'[1] = [19, 22, 24].

After testing all permutations, the maximum solution array has 3 elements.


Function Description

Complete the nonDivisibleSubset function in the editor below.

nonDivisibleSubset has the following parameter(s):

- int S[n]: an array of integers
- int k: the divisor


Returns

- int: the length of the longest subset of S meeting the criteria


Input Format

The first line contains 2 space-separated integers, n and k, the number of values in S and the non factor.

The second line contains n space-separated integers, each an S[i], the unique values of the set.


Constraints

1 <= n <= 10^5

1 <= k <= 100

1 <= S[i] <= 10^9

All of the given numbers are distinct.
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
         // Write your code here
         //TC: O(n)
         //SC: O(n)
         //Unintuit  
          int count[]=new int[k];
          for(int ele:s){
            count[ele%k]++;
          }
          int ans = 0;
          if(count[0]>0) ans++;
          for(int i=1;i<=k/2;i++){
            // even k case
              if(i==(k-i)){
                //select at most 1
                if(count[i]>0) ans++;
              }else{
                 ans+=Math.max(count[i],count[k-i]);
              }
          }
          return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
