package com.leecode.链表;

public class _2_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummyHead = new ListNode(0);
        ListNode last = dummyHead;
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
            last.next = new ListNode((v1 + v2) % 10 + carry);
            carry = (v1 + v2) / 10;
            last = last.next;
        }
        if (carry != 0){
            last.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
