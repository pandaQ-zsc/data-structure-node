package com.lee.asia;

import com.lee.链表.ListNode;

public class _2_两数相加 {
    //输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    //输出：[8,9,9,9,0,0,0,1]
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            int v2 = 0;
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }
            int tmp = v1 + v2 + carry;
            carry = tmp / 10;
            pre.next = new ListNode(tmp % 10);
            pre = pre.next;
        }
        if (carry != 0) {
            pre.next = new ListNode(carry);
        }
        return dummy.next;


    }
}
