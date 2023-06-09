package com.collection;

import com.lee.链表.ListNode;

/**
 * @author: xiong.qiang
 * @date: 2023/6/5 14:59
 */
public class LinkedListStack {
    private ListNode stackPeek;
    private int stkSize = 0;
    public LinkedListStack(){
        stackPeek = null;
    }

    public int size(){
        return stkSize;
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    public void push(int num){
        ListNode node = new ListNode(num);
        node.next = stackPeek;
        stackPeek  = node;
        stkSize ++;
    }
    public int pop(){
        if (stkSize == 0){
            throw new IndexOutOfBoundsException();
        }
        return stackPeek.val;
    }

    // 将链表转化成Array返回
    public int[] toArray(){
        ListNode node = stackPeek;
        int[] res = new int[size()];
        for(int i = res.length-1;i>0;i--){
            res[i] = node.val;
            node = node.next;
        }
        return res;
    }
}
