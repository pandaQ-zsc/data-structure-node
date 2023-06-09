package com.lee.asia;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: xiong.qiang
 * @date: 2023/5/26 17:13
 */
public class _667_BeautifulArrangement {
//构造规则：
//
//先从1开始，依次加1，连续构造 n-k 个数字；
//再从n开始，交叉增加/减少，差值绝对值从k-1开始，依次减1，构造完剩余的数字
//举例：
//
//n = 6, k = 4:
//先构造：1,2
//再交叉构造：6,3,5,4  (从n开始，差值绝对值从k-1开始依次减1，先降低，再增大，依次交叉构造)
//
//n = 6, k = 3:
//先构造：1,2,3
//再交叉构造：6,4,5
//    public static int[] constructArray(int n, int k) {
//        int[] ans = new int[n];
//        int index = 0;
//        for (int i = 1; i <= n-k; i++) ans[index++] = i; // 先从1开始，依次加1，连续构造 n-k 个数字
//        int num = n, diff = k-1, dir = -1; // 再从n开始，差值绝对值从k-1开始依次减1，先降低，再增大，依次交叉构造剩余数字
//        while (index < n) {
//            ans[index++] = num;
//            num += (dir * diff);
//            dir *= -1; // 变换方向
//            diff--; // 差值绝对值依次减1
//        }
//        return ans;
//    }
    public static int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int index = 0;
        for (int i = 1; i <= n-k; i++) ans[index++] = i; // 先从1开始，依次加1，连续构造 n-k 个数字
        int num = n, diff = k-1, dir = -1; // 再从n开始，差值绝对值从k-1开始依次减1，先降低，再增大，依次交叉构造剩余数字
        while (index < n) {
            ans[index++] = num;
            num += (dir * diff);
            dir *= -1; // 变换方向
            diff--; // 差值绝对值依次减1
        }
        return ans;
    }

//Description:
    //Suppose this list is answer =[a1, a2, a3, ... , an], then the list [|a1 - a2|,
    // |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
//Answer Ref:
    //Input: n = 3, k = 2
    //Output: [1,3,2]
    //Explanation: The [1,3,2] has three different positive integers ranging from 1 to 3,
    // and the [2,1] has exactly 2 distinct integers: 1 and 2.

    public static void main(String[] args) {
        int[] res = constructArray(3, 2);
        System.out.println(Arrays.toString(res));

    }
}
