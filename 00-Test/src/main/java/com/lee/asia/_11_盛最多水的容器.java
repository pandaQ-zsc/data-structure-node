package com.lee.asia;

public class _11_盛最多水的容器 {
    //输入：[1,8,6,2,5,4,8,3,7]
    //输出：49
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0, r = height.length - 1, water = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                water = Math.max(height[l] * (r - l), water);
                l++;
            } else {
                water = Math.max(height[r] * (r - l), water);
                r--;
            }
        }
        return water;
    }
}
