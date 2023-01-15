package com.leecode.栈_队列;

import java.util.Stack;

class MinStack {

    private  Stack<Integer> stack;
    private  Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()){
            minStack.push(val);
        }else {
            minStack.push(Math.min(minStack.peek(),val));
        }
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
            return minStack.peek();
    }
}
