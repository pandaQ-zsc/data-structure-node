package com.lee.贪心;

public class _860_柠檬水找零 {
    //输入：bills = [5,5,5,10,20]
    //输出：true
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                ten++;
                five--;
                if (five < 0) {
                    return false;
                }
            } else if (bill == 20) {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five > 2) {
                    five = five -3;
                }else  return false;
            }
        }
        return true;
    }
}
