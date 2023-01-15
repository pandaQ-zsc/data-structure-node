package com.leecode.高频题;

import com.leecode.链表.ListNode;

public class _206_反转链表 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
       ListNode prev = null;
       while(head != null){
           ListNode tmp = head.next;
           head.next = prev;
           prev = head;
           head = tmp;
       }
       return prev;
    }
}

