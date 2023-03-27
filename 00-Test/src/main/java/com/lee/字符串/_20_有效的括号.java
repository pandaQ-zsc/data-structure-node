package com.lee.字符串;

import java.util.Stack;

public class _20_有效的括号 {
    public static boolean isValid(String s) {
        int length = s.length();
        if (s == null || s.length() == 0) return false;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (stack.isEmpty() ||s.charAt(i) != stack.pop() ){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        isValid("()");
    }
}
