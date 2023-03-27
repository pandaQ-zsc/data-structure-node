package com.lee.位运算;

//
//        1: 0001     3:  0011      0: 0000
//        2: 0010     6:  0110      1: 0001
//        4: 0100     12: 1100      2: 0010
//        8: 1000     24: 11000     3: 0011
//        16:10000    48: 110000    4: 0100
//        32:100000   96: 1100000   5: 0101
public class _338_比特位计数 {
    public int[] countBits(int num) {
        int [] res = new int[num+1];
        for (int i = 0; i <= num; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }
    public int[] countBits2(int num) {
        int [] res = new int[num+1];
        for (int i = 0; i <= num; i++) {
            res[i] = countOne(i);
        }
        return res;

    }
    public int countOne(int n){
      int count = 0;
      while(n!=0){
          if ((n&1)==1){
              count++;
          }
          n>>=1;
      }
      return count;
    }

}
