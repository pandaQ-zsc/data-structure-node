package com.leecode.高频题;


import java.util.HashMap;

/*
 * https://leetcode.cn/problems/remove-element/
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。

 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

 示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。

 示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。

 你不需要考虑数组中超出新长度后面的元素
 * @param nums
 * @param val
 * @returns {number}
 */
public class _27_移除元素 {

    public static void main(String[] args) {
//        int res = removeElement(new int[]{3, 2, 2, 3},3);
        //good choose : removeElement
        int res = removeElement(new int[]{3, 2, 3, 2, 2, 2, 3}, 3);
        int res2 = removeElement2(new int[]{3, 2, 3, 2, 2, 2, 3}, 3);
        int res3 = removeElement3(new int[]{3, 2, 3, 2, 2, 2, 3}, 3);
        int res4 = removeElement5(new int[]{3, 2, 3, 2, 2, 2, 3}, 3);
        System.out.println(res);
//        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
    }

    public static int removeElement5(int[] nums, int val) {
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[l]) {
                nums[l] = nums[i];
                l++;
            }
        }
        return l;
    }

    public static int removeElement4(int[] nums, int val) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num == val) {
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
        }
        return nums.length - map.get(val);
    }


    public static int removeElement3(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            } else {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static int removeElement2(int[] nums, int val) {

        // 快慢指针
        int fastIndex = 0;
        int slowIndex;
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;

    }

    public static int removeElement(int[] nums, int val) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[res++] = nums[i];
            }
        }
        return res;

    }

}

