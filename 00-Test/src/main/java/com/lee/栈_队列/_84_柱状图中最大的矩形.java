package com.lee.栈_队列;

import java.util.ArrayDeque;
import java.util.Deque;

public class _84_柱状图中最大的矩形 {
    //输入：heights = [2,1,5,6,2,3]
    //输出：10
    //解释：最大的矩形为图中红色区域，面积为 10


    //我们在遍历的时候，需要记录的是下标，如果当前的高度比它之前的高度严格小于的时候，
    // 就可以直接确定之前的那个高的柱形的最大矩形的面积，
    // 为了确定这个最大矩形的左边界，我们还要找到第一个严格小于它的高度的矩形，
    // 向左回退的时候，其实就可以当中间这些柱形不存在一样。

    //【要点】：
    //什么时候元素出栈：当前元素的高度小于栈顶元素的高度的时候
    //矩形宽度：【当前遍历的下标-出栈以后的新栈顶下标-1】
    //高度： 下标访问高度
    //遍历每个元素时【栈里面都是什么元素】:高度比当前元素小的下标
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            // 这个 while 很关键，因为有可能不止一个柱形的最大宽度可以被计算出来
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                //当前栈顶元素的高度
                int curHeight = heights[stack.pollLast()];
                //特殊情况：当前栈顶元素 等于原来旧的栈顶元素高度
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }
                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {//一般情况下
                    curWidth = i - stack.peekLast() - 1;
                }
                res = Math.max(res, curHeight * curWidth);
            }
            //当栈为空或者  当前遍历元素 》= 栈顶元素高度
            stack.addLast(i);
        }
        //将当前栈中所有的元素弹出
        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                //最后一个元素已经poll了所以这里的peek是上一个
                curWidth = len - stack.peekLast() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;

    }
}
