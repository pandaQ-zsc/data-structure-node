package com.lee.栈_队列;

import java.util.Deque;
import java.util.LinkedList;

public class _155_最小栈 {

    private final Deque<Integer> minStack;
    private final Deque<Integer> stack;

    //设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
    //
    //push(x) —— 将元素 x 推入栈中。
    //pop()—— 删除栈顶的元素。
    //top()—— 获取栈顶元素。
    //getMin() —— 检索栈中的最小元素。
    //
    public _155_最小栈() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();

    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()|| val <= minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop() {
       int x = stack.pop();
       if (x == minStack.peek()){
           minStack.pop();
       }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (minStack.size() == 0) return -1;
        return minStack.peek();
    }
}
