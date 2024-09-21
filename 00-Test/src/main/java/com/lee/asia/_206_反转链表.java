package com.lee.asia;

import com.lee.链表.ListNode;

import java.util.Stack;

//https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
public class _206_反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;

    }
    //迭代方法 （掌握）
    public ListNode reverseList2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while(head!= null){
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty()) return head;
        ListNode node = stack.pop();
        ListNode dummy = node;
        while(!stack.isEmpty()){
            node.next = stack.pop();
            node = node.next;
        }
        node.next =null;
        return dummy;
    }

/*    //递归方法 （理解）
    public ListNode reverseList(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if(head==null || head.next==null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList(head.next);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }*/


}

