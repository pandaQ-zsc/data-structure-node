package com.lee.asia;

public class _11_v1盛最多水的容器 {
    //输入：[1,8,6,2,5,4,8,3,7]
    //输出：49
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0, r = height.length - 1, max = Integer.MIN_VALUE;
        while (l < r) {
            if (height[l] <= height[r]) {
                max = Math.max(max, height[l] * (r - l));
                l++;
            }
            if (height[r] < height[l]) {
                max = Math.max(max, height[r] * (r - l));
                r--;
            }
        }
        return max;
    }
}
