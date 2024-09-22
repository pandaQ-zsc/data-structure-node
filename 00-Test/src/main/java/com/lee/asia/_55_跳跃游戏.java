package com.lee.asia;


import org.junit.Assert;

import java.time.OffsetDateTime;
import java.util.UnknownFormatConversionException;

/**
 * @author Xiong Qiang
 * @date 2024/9/21 16:52
 */

public class _55_跳跃游戏 {
    //示例 1：
    //
    //输入：nums = [2,3,1,1,4]
    //输出：true
    //解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
    //示例 2：
    //
    //输入：nums = [3,2,1,0,4]
    //输出：false
    //解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标
    // [1,2]
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0; // 初始化最远能跳跃到的位置

        // 遍历数组中的每一个位置
        for (int i = 0; i < n; ++i) {
        // 如果当前位置 i 可以到达（即 i <= rightmost）
            //判断当前位置 i 是否在当前能够到达的范围内（
            if (i <= rightmost) {
                // 更新最远能跳跃到的位置
                rightmost = Math.max(rightmost, i + nums[i]);

                // 如果最远能跳跃到的位置已经超过了或等于最后一个元素的位置
                if (rightmost >= n - 1) {
                    // 则可以直接到达最后一个元素，返回 true
                    return true;
                }
            }
        }
        // 如果遍历完数组都无法到达最后一个元素，返回 false
        return false;
    }

    public static boolean canJump2(int[] nums) {
        int rightmost =0;
        for(int i = 0 ; i <= nums.length -1 ; i++){
            if (i <= rightmost){
                rightmost = Math.max(rightmost,nums[i] + i);
            }
            if (rightmost >= nums.length-1){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

}
