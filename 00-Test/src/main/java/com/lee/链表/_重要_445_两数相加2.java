package com.lee.链表;

import java.util.Stack;

public class _重要_445_两数相加2 {
    //输入：l1 = [7,2,4,3], l2 = [5,6,4]
    //输出：[7,8,0,7]

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //初始化stack
        Stack<Integer> stack1 = buildStack(l1);
        Stack<Integer> stack2 = buildStack(l2);
        //新建前驱结点方便返回
        ListNode pre = new ListNode(-1);
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int x = stack1.isEmpty() ? 0 : stack1.pop();
            int y = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            //node插入到头结点（pre后面）
            // 第一次pre.next == null 插入后变成 pre - > node -> null
            node.next = pre.next;
            pre.next = node;
            //计算是否有进位
            carry = sum / 10;
        }
        return pre.next;
    }

    public Stack<Integer> buildStack(ListNode head) {
        ListNode node = head;
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        return stack;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = buildStack2(l1);
        Stack<Integer> stack2 = buildStack2(l2);
        ListNode pre = new ListNode(-1);
        int carry = 0;
        while(!stack1.isEmpty()||!stack2.isEmpty() || carry != 0 ){
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = a + b + carry;
            ListNode node = new ListNode(sum%10);
             node.next = pre.next;
             pre.next = node;
            carry = sum / 10;
        }
        return pre.next;



    }

    public Stack<Integer> buildStack2(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while (node != null){
            stack.push(node.val);
            node = node.next;
        }
        return stack;

    }


}
