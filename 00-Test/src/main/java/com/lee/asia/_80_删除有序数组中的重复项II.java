package com.lee.asia;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author Xiong Qiang
 * @date 2024/9/19 22:13
 */

//示例 1：
//
//输入：nums = [1,1,1,2,2,3]
//输出：5, nums = [1,1,2,2,3]
//解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
//示例 2：
//
//输入：nums = [0,0,1,1,1,1,2,3,3]
//输出：7, nums = [0,0,1,1,2,3,3]
//解释：函数应返回新长度 length = 7, 并且原数组的前七个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
public class _80_删除有序数组中的重复项II {
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int currentIndex = 2;
        int prev2 = nums[0];    // 前2个元素的值
        int prev = nums[1];     // 前1个元素的值
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != prev2 || nums[i] != prev) {
                nums[currentIndex++] = nums[i]; // 没有跟前两个都相同, 就原地修改,相当于前移
            }
            prev2 = prev;
            prev = nums[i];
        }
        return currentIndex;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums.length <= 2) {
            // 如果数组长度小于等于2，直接返回数组长度。
            return nums.length;
        }

        int slow = 2; // 慢指针，初始位置为2，表示至少保留前两个元素
        int fast = 2; // 快指针，从数组的第三个元素开始

        // 当快指针未到达数组末尾时，进行循环
        while (fast < nums.length) {
            // 如果当前元素nums[fast]与两个位置之前的元素不同，
            if (nums[slow - 2] != nums[fast]) {
            // 则将当前元素nums[fast]复制到慢指针nums[slow]的位置，并将慢指针向前移动一步
                nums[slow++] = nums[fast];
            }
            // 快指针向前移动一步
            fast++;
        }

        // 输出修改后的数组
        System.out.println(Arrays.toString(nums));

        // 返回新的有效数组长度
        return slow;
    }

    public static int removeDuplicates3(int[] nums) {
        if (nums.length < 2){
            return nums.length;
        }
        int slow =2;
        int fast = 2;
        while(fast != nums.length){
            if (nums[fast] != nums[slow-2]){
                nums[slow++] = nums[fast];
            }
        fast++;
        }
        System.out.println(Arrays.toString(nums));
        return slow;
    }


    public static void main(String[] args) {
//        int i = removeDuplicates2(new int[]{0,0,1,1,1,1,2,3,3});
        int i = removeDuplicates2(new int[]{0,0,1,1,1,1,2,3,3});
        System.out.println(i);

    }

}
