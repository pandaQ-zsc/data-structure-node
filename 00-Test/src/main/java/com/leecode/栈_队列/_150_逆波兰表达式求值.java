package com.leecode.栈_队列;

import java.util.ArrayDeque;
import java.util.Deque;
//输入：tokens = ["4","13","5","/","+"]
//输出：6
//解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
public class _150_逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token : tokens){
            if (!("/".equals(token)||"*".equals(token)||"+".equals(token)||"-".equals(token))){
                stack.push(Integer.valueOf(token));
            }else {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                if (token.equals("/")){
                    stack.push(num1 /num2 );
                } else if (token.equals("*")){
                    stack.push(num1 * num2 );
                }else if (token.equals("+")){
                    stack.push(num1 + num2 );
                }else {
                    stack.push(num1-num2);
                }
            }
        }
        return stack.pop();
    }
}

