package com.leecode.字符串;

import java.util.ArrayDeque;
import java.util.Stack;

// abbaca
public class _1047_删除字符串中的所有相邻重复项 {
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty() || ch != stack.peek()) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }
        StringBuilder builder = new StringBuilder("");
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }

    // 字符串 模拟 栈 // abbaca
    public static String removeDuplicates2(String s) {
        StringBuilder builder = new StringBuilder();
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (top>=0 && builder.charAt(top) == ch){
                builder.deleteCharAt(top);
                top--;
            }else {
                builder.append(ch);
                top++;
            }
        }
       return builder.toString();

    }


    public static void main(String[] args) {
        String abbaca = removeDuplicates2("abbaca");
        System.out.println(abbaca);
    }
}
