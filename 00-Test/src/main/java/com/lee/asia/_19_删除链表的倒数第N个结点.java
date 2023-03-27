package com.lee.asia;

import com.lee.链表.ListNode;

//https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/dong-hua-tu-jie-leetcode-di-19-hao-wen-ti-shan-chu/
public class

_19_删除链表的倒数第N个结点 {
    //我们可以设想假设设定了双指针 p 和 q 的话，当 q 指向末尾的 NULL,
    // p 与 q 之间相隔的元素个数为 n 时,那么删除掉 p 的下一个指针就完成了要求。
    //
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode fast = dummy;
        ListNode slow = dummy;
        dummy.next = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
