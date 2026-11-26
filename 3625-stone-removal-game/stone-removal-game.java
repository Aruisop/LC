class Solution {
     public boolean canAliceWin(int n) {
             if(n<10) return false; 
             int p1_r = n-10;
             //if p1 removes 10 stones then; we have p2 needs to remove 9 and then p1 needs to conseq need to remove  stones once thats done
             if(p1_r<9) return true;
             int prev = p1_r;
             int sub1 = 9;
             boolean bob_win = false, alice_win=false;
             int k = 0;
             while((prev-sub1)>=0){
                 prev-=sub1;
                 sub1-=1;
                 k++;
             }
             return (k%2==0)?true:false;
     }
}