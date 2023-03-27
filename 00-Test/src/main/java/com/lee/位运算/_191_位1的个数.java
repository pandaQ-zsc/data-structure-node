package com.lee.位运算;

//输入：00000000000000000000000000001011
//输出：3
//解释：输入的二进制串 00000000000000000000000000001011中，共有三位为 '1'。
//https://leetcode-cn.com/problems/number-of-1-bits/solution/fu-xue-ming-zhu-xiang-jie-wei-yun-suan-f-ci7i/
//只要每次执行这个操作 n & (n - 1)，就会消除掉 n 的二进制中 最后一个出现的 1。
//   n   : 110100
//  n-1  : 110011
// n&n-1 : 110000
//算术右移 >> ：舍弃最低位，高位用符号位填补；
//逻辑右移 >>> ：舍弃最低位，高位用 0 填补。
// 那么对于负数而言，其二进制最高位是 1，如果使用算术右移，
// 那么高位填补的仍然是 1。也就是 n 永远不会为 0。所以下面的代码会超时 TLE。
public class _191_位1的个数 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while(n!=0){
            if ((n&1) == 1){
                count++;
            }
            n = n >>>1;
        }
        return count;

    }

}
