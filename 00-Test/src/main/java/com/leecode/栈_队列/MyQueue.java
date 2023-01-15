package com.leecode.栈_队列;

import java.util.Stack;

class MyQueue {
    private final Stack<Integer> in;
    private final Stack<Integer> out;

    //void push(int x) 将元素 x 推到队列的末尾
    //int pop() 从队列的开头移除并返回元素
    //int peek() 返回队列开头的元素
    //boolean empty() 如果队列为空，返回 true ；否则，返回 false

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        in.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */