package com.lee.排序_数组;

public class _66_加一 {
    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     */
    //输入：digits = [1,2,3]
    //输出：[1,2,4]
    //解释：输入数组表示数字 123
    // 99 499 999 909  910
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }

        }
        //如果所有位都是进位，则长度+1
        digits= new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
    public int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


    //输入：digits = [1,2,3]
    //输出：[1,2,4]
    //解释：输入数组表示数字 123
    // 99 499 999  9
    public int[] plusOne3(int[] digits) {
        for(int i = digits.length-1 ; i >= 0 ; i--){
            digits[i] ++ ;
//            if (digits[i] == 0){    // 当传入为【9】的时候有问题,此时digits[i] = 10;
            if (digits[i] % 10 == 0 ){
                //避免 digits[i] ++  后是10后直接加入到digits[]中，
                //题目要求是++后若是10则直接拆解为1,0
                digits[i] = 0;
            }else {
                return digits;
            }
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }

}
