package com.lee.贪心;

import java.util.Arrays;
//https://leetcode-cn.com/problems/candy/solution/java-liang-chong-fang-shi-tu-wen-xiang-j-a2v8/
//输入：[1,0,2]
//输出：5
//解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
public class _135_分发糖果 {
    public int candy2(int[] ratings) {
      int length = ratings.length;
      int [] count = new int[length];
      Arrays.fill(count,1);
        for (int i = 1; i <length ; i++) {
            if (ratings[i] > ratings[i-1]){
                count[i] = count[i-1]+1;
            }
        }
        int total = count[length-1];
        for (int i = length-1; i >0 ; i--) {
            if (ratings[i-1] > ratings[i]){
                count[i-1] = Math.max(count[i-1],count[i]+1);
            }
            total += count[i-1];
        }
        return total;
    }


    public  int candy(int[] ratings) {
        int length = ratings.length;
        //记录的是从左往右循环的结果
        int[] left = new int[length];
        //记录的是从右往左循环的结果
        int[] right = new int[length];
        //因为每个孩子至少有一个糖果，默认都给他们一个
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        //统计最少的总共糖果数量
        int total = 0;
        //先从左往右遍历，如果当前孩子的得分比左边的高，
        //那么当前孩子的糖果要比左边孩子的多一个
        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
        }
        //然后再从右往左遍历，如果当前孩子的得分比右边的高，
        //那么当前孩子的糖果要比右边边孩子的多一个
        for (int i = length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i])
                right[i - 1] = right[i] + 1;
        }
        //要满足左右两边的条件，那么当前孩子的糖果就要取
        //从左往右和从右往左的最大值。
        for (int i = 0; i < length; i++) {
            //累计每个孩子的糖果
            total += Math.max(left[i], right[i]);
        }
        return total;
    }


}
