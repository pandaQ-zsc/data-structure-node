package com.leecode.位运算;

public class _9_回文数 {
    public boolean isPalindrome(int x) {
        if (x <0) return false;
        if (x == 0) return true;
        int reverseNum = reverse(x);
        return reverseNum == x;
    }

    private int reverse(int x) {
        int res = 0;
        while(x!=0){
            res = res *10 + x%10;
            x /=10;
        }
        return res;
    }
}
