package com.leecode.链表;

public class _142_环形链表2 {
    //输入：head = [3,2,0,-4], pos = 1
    //输出：返回索引为 1 的链表节点
    //解释：链表中有一个环，其尾部连接到第二个节点。
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        fast = head;
        //第二阶段，找环接入点
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
