package com.lee.asia;

import java.util.Stack;

public class _32_最长有效括号 {
    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                //如果栈为空，说明当前的右括号为没有被匹配的右括号，
                // 我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
