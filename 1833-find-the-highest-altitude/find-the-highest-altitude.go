 package main
 import (
 "fmt"
 "math"
 )
 func largestAltitude(gain []int) int {
      //TC: O(n)
      //SC: O(n)
      // golang
     cpy := make([]int,1)
     cpy[0] = 0
     for _ , ele := range gain {
     cpy = append(cpy,ele)
     }
     fmt.Println(cpy)
     ans := make([]int,1)
     ans[0] = 0
     var putele = 0
     for _,  ele := range cpy{
       putele += ele
       ans = append(ans,putele)
     }
     maxInteger := math.MinInt
     for _, ele := range ans {
        maxInteger = max(maxInteger,ele)
     }
     return maxInteger
}