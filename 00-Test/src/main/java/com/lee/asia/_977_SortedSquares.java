package com.lee.asia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author: xiong.qiang
 * @date: 2023/3/20 17:44
 */
//示例 1：
//
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100]
//示例 2：
//
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
//

public class _977_SortedSquares {
    //Processing idea:  double pointer
    public static int[] sortedSquares(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num * num);
        }
        list.sort(Comparator.comparingInt(a -> a));
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static int[] sortedSquares2(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int index = nums.length -1;
        int[] res = new int[nums.length];
        while (l <= r) {
            if (nums[l] * nums[l] < nums[r] * nums[r]) {
                res[index--] = nums[r] * nums[r];
                r--;
            } else {
                res[index--] = nums[l] * nums[l];
                l++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = sortedSquares(new int[]{-7, -3, 2, 3, 11});
        System.out.println(Arrays.toString(ints));
        int[] ints2 = sortedSquares2(new int[]{-7, -3, 2, 3, 11});
        System.out.println(Arrays.toString(ints2));

    }
}
