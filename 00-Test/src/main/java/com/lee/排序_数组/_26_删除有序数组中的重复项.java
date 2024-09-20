package com.lee.排序_数组;

import java.util.Arrays;

//输入：nums = [1,1,2,2]
//输出：2, nums = [1,2]
//解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
public class _26_删除有序数组中的重复项 {
    public int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                if (q - p > 1) {
                    nums[p + 1] = nums[q];
                }
                 p++;
            }
            q++;
        }

        return p + 1;
    }


    public int removeDuplicates(int[] nums) {
        // 这里的index就是慢指针 也就是每次找到不同值需要插入的位置
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;

    }

    public static int removeDuplicates3(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int slow = 1;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }


    //例 1：
    //输入：nums = [1,1,2]
    //输出：2, nums = [1,2,_]
    //解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
    //示例 2：
    //输入：nums = [0,0,1,1,1,2,2,3,3,4]
    //输出：5, nums = [0,1,2,3,4]
    //解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
    public static void main(String[] args) {
        int res = removeDuplicates3(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println(res);
    }

}
