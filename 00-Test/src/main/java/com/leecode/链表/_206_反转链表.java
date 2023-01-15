package com.leecode.链表;

import com.sort.HeapSort;

import java.util.List;

public class _206_反转链表 {


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
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

    public ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;

    }
}

