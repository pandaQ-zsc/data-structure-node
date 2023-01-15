package com.leecode.链表;

import java.util.Stack;

public class _20_有效的括号 {
    //okk
    public boolean isValid2(String s) {
        if (s.isEmpty()) return  false;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        if (s.isEmpty()) return  false;
        Stack<Character> stack = new Stack<Character>();
        for( char c : s.toCharArray()){
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if(stack.empty() || c != stack.pop()){
                return false;
            }
        }
        return stack.empty();
    }
}
