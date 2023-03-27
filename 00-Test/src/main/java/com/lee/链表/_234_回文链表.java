package com.lee.链表;

import java.util.ArrayList;
import java.util.List;

//涉及到
// 【重要】pivot链表(https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/)
public class _234_回文链表 {
    // 1、 复制链表到数组列表中
    // 2、 使用双指针法判断是否为回文
    public boolean isPalindrome2(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        //将链表的值复制到数组中
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (!list.get(l).equals(list.get(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    //1 找到前半部分链表的尾节点。
    //2 反转后半部分链表。
    //3 判断是否回文。
    //4 恢复链表。
    //5 返回结果。
    public boolean isPalindrome(ListNode head) {
        // 特殊情况
        if (head == null || head.next == null) {
            return true;
        }

        // 利用快慢指针划分前半部分和后半部分
        ListNode fast = head.next;  // 快指针，为了便于后续从中间划分，故fast从第二个节点出发
        ListNode slow = head;  // 慢指针

        // 快指针走两步，慢指针走一步。当fast==null（奇数）或fast.next==null(偶数)，
        // 代表slow走到了中间，且奇数时，中间节点应该属于前半部分
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 从slow处进行划分。偶数时，前半部分后半部分各占一半；奇数时，前半部分包括中间节点
        ListNode head2 = slow.next;  // 后半部分链表
        slow.next = null;  // 前半部分链表
        head2 = reverseList(head2);  // 原地反转后半部分链表--Leet206

        // 前半部分链表和反转后的后半部分链表进行元素对比，若全相同，则为回文
        while (head2 != null) {  // 因为肯定是后半部分链表长度小于等于前半部分链表（奇数的中间节点划分给前半部分了）
            if (head.val != head2.val)
                return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    // 迭代法求解反转链表--Leet206
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;   // 用来存储之前cur的下一个节点，方便往后移动
            cur.next = prev;  // 之前的连接关系不再存在，变成这个新的
            // 往后移动
            prev = cur;
            cur = temp;  // 此时的cur.next已经变了，故要使用之前暂存的temp
        }
        return prev;  // 此时的反转后的新链表的头节点变为了prev

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(3);
        System.out.println(head);
        _234_回文链表 obj = new _234_回文链表();
        obj.isPalindrome(head);
        System.out.println(head);

    }
}

