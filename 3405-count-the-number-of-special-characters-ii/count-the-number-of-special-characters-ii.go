 package main
 import "fmt"
 func numberOfSpecialChars(word string) int {
     lower:= make(map[byte]int)
     upper:= make(map[byte]int)
     n := len(word)
     for i:=0;i<n;i++{
         ch := word[i]
         if ch>='a' && ch<='z'{
           lower[ch]=i
         }
     }
     for i:=0;i<n;i++{
          ch := word[i]
          if ch>='A' && ch<='Z'{
             if _, exists := upper[ch]; !exists{
              upper[ch]=i
             }
          }
     }
     ct:= 0
     for ch:=range lower{
         up:= ch-32
         smind := lower[ch]
         uind,exists := upper[up]
         if exists && smind<=uind{
            ct++
         }
     }
     return ct
 }