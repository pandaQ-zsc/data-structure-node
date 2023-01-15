package com.leecode.高频题;

import com.leecode.链表.ListNode;

public class _141_环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        if (slow == fast) return true;
        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }
        return false;

    }
}
