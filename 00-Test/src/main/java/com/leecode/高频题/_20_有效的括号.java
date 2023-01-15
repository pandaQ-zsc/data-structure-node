package com.leecode.高频题;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _20_有效的括号 {
    //输入：s = "([)]"
    //输出：false
    public boolean isValid(String s) {
        int length = s.length();
        if (s == null || s.length() == 0 )return false;

         Stack<Character>stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '('){
                stack.push(')');
            }else if (s.charAt(i)== '['){
                stack.push(']');
            }else if (s.charAt(i) == '{'){
                stack.push('}');
            }else if (stack.isEmpty() || stack.peek() != s.charAt(i)){
                return false;
            }else {
                stack.pop();
            }
        }
        return stack.isEmpty();

    }
}
