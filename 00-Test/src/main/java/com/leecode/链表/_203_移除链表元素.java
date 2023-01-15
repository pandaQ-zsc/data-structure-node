package com.leecode.链表;

import com.leecode.common.Node;

public class _203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
       if (head == null) return null;
       ListNode dummy = new ListNode(-1);
       dummy.next = head;
       ListNode prev = dummy;
       ListNode cur = head;
       while(cur != null) {
           if (cur.val == val){
               prev.next = cur.next;
           }else {
               prev = cur;
           }
           cur = cur.next;
       }
       return dummy.next;
    }
}
