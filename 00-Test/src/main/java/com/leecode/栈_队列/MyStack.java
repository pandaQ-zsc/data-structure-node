package com.leecode.栈_队列;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private  Queue<Integer> queue2;
    private  Queue<Integer> queue1;
    //实现 MyStack 类：
    //
    //void push(int x) 将元素 x 压入栈顶。
    //int pop() 移除并返回栈顶元素。
    //int top() 返回栈顶元素。
    //boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue2.offer(x);
        while(!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        Queue<Integer> tmp = queue2;
        queue2 = queue1;
        queue1 = tmp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */