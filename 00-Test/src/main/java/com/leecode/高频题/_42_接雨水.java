package com.leecode.高频题;

import java.util.Stack;
//https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
public class _42_接雨水 {
    //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
    // 计算按此排列的柱子，下雨之后能接多少雨水。
    //输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
    //输出：6
 //我们可以认为如果一端有更高的条形块（例如右端），
    // 积水的高度依赖于当前方向的高度（从左到右）。
    // 当我们发现另一侧（右侧）的条形块高度不是最高的，
    // 我们则开始从相反的方向遍历（从右到左）。
    public int trap(int[] height) {
      int left = 0 ,right = height.length-1;
      int left_max = 0 ,right_max = 0;
      int res = 0 ;
      while(left< right){
          if (height[left] < height[right]){
              if (height[left] >=left_max){
                  left_max = height[left];
              }else {
                  res += (left_max - height[left]);
              }
              left++;
          }else {
              if (height[right] >= right_max){
                  right_max = height[right];
              }else {
                  res += right_max -height[right];
              }
              right--;
          }
      }
      return res;
    }
//https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
    public int trap2(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int h = stack.pop();
                    if (stack.isEmpty()) break;
                    int distance = i -stack.peek() -1;
                    //水量就是 Min ( max _ left ，max _ right ) - height [ i ]
                    int min = Math.min(height[stack.peek()],height[i]);
                    sum += distance * (min - h);

            }
            stack.push(i);
        }
        return sum;
    }
}
