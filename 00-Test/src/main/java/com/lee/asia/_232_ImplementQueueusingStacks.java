package com.lee.asia;

import java.util.Stack;

/**
 * @author: xiong.qiang
 * @date: 2023/5/5 17:10
 */

//输入：
//["MyQueue", "push", "push", "peek", "pop", "empty"]
//[[], [1], [2], [], [], []]
//输出：
//[null, null, null, 1, 1, false]
//
//解释：
//MyQueue myQueue = new MyQueue();
//myQueue.push(1); // queue is: [1]
//myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
//myQueue.peek(); // return 1
//myQueue.pop(); // return 1, queue is [2]
//myQueue.empty(); // return false
//
public class _232_ImplementQueueusingStacks {

    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();


    public void push(int x) {
        in.push(x);
    }

    private void in2out() {
        if (out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
    }

    public int pop() {
        in2out();
        return out.pop();
    }

    public int peek() {
        in2out();
        return out.peek();

    }

    public boolean empty() {
        return in.empty() && out.empty();
    }
}
