package com.leecode.栈_队列;

import java.util.*;

public class _20_有效的括号 {
    //输入：s = "()"
    //输出：true
    //输入：s = "([)]"
    //输出：false
    public boolean isValid(String s) {
        if (s.isEmpty()) return false;
        Deque<Character> stack = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
    //输入：s = "[()]"
    //输出：true
    //输入：s = "([)]"
    //输出：false
    public boolean isValid2(String s) {
        if (s.length() %2 == 1 || s.length() == 0){
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                if (stack.isEmpty() || stack.peek() != map.get(c)){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
    // {{([])}}
    // {(]);
    public boolean isValid3(String s) {
        int length = s.length();
        if (length == 0 || length %2 ==1){
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0 ; i < length; ++i){
            char c = s.charAt(i);
            if (!map.containsKey(c)){
                stack.push(c);
            }else if (map.get(c) != stack.peek()){
                return false;
            }else {
                stack.pop();
            }

        }
        return stack.isEmpty();
    }

}
