package com.leecode.高频题;

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
    //Processing idea:  double point
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
        int[] res = new int[nums.length];
        int index = nums.length - 1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                res[index--] = nums[l] * nums[l];
                l++;
            } else {
                res[index--] = nums[r] * nums[r];
                r--;
            }
        }
        String s = Arrays.toString(nums);
        System.out.println("--------->" + s);
        String[] strArr = new String[]{"1", "3", "4", "4"};
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        Collections.addAll(integerArrayList);
        return res;
    }

    public static void main(String[] args) {
        int[] ints = sortedSquares(new int[]{-7, -3, 2, 3, 11});
        int[] ints2 = sortedSquares2(new int[]{-7, -3, 2, 3, 11});

    }
}
