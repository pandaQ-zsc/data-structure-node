package com.leecode.高频题;

import java.util.Arrays;

/**
 * Created by XQ
 * 2022/8/16
 *
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class _283_移动零 {
    public static  void moveZeroes(int[] nums) {
        int slow = 0 ;
        for(int i = 0 ; i< nums.length ;i++){
            if (nums[i] != 0){
                nums[slow++]  = nums[i];
            }
        }
        //1,3,12,3,12
        while(slow < nums.length){
            nums[slow++] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        moveZeroes( new int[] {0,1,0,3,12});

    }

}
