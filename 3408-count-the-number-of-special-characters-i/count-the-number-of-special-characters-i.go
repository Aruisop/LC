 package main 
 import "fmt"

 func numberOfSpecialChars(word string) int {
     //in go
     lcase := make(map[byte]bool)
     ucase := make(map[byte]bool)
     n := len(word)
     for i:=0;i<n;i++ {
         ch := word[i]
         if ch>='a' && ch<='z'{ 
          lcase[ch] = true
         }
         if ch>='A' && ch<='Z'{ 
          ucase[ch] = true
         }
     }
     ct := 0
     for ch := range lcase{
         upper := ch - 32
         if ucase[upper]==true{
            ct++;
         }
     }
     return ct   
 }