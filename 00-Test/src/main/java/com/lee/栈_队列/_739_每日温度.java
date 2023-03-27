package com.lee.栈_队列;

import java.util.Stack;

public class _739_每日温度 {
    //输入: temperatures = [73,74,75,71,69,72,76,73]
    //输出: [1,1,4,2,1,1,0,0]

    //通过索引以及链表求出新的T
    //运用栈，如果小于栈顶值存入栈，如果大于栈顶的值就将栈顶元素出栈，
    // 然后计算距离存入结果数组，反复出栈直到不满足大于栈顶元素
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return null;
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < result.length; i++) {

            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int k = stack.pop();
                result[k] = i - k;
            }
            stack.push(i);
        }
        return result;
    }

    public int[] dailyTemperatures2(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while(!stack.isEmpty() && T[i]>T[stack.peek()]){
                int pre= stack.pop();
                res[pre] = i  - pre;
            }
            stack.push(i);
        }
        return res;
    }



}
