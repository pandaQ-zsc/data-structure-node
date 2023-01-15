package com.leecode.高频题;

import com.leecode.链表.ListNode;

import java.util.*;

//!!!【归并排序】!!!!!
//https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
public class _148_排序链表 {
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHead = slow.next;
        //断开链表
        slow.next = null;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        // // 合并两个有序链表（21. 合并两个有序链表）
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        while (left != null && right != null) {
            if (left.val < right.val) {
                pre.next = left;
                left = left.next;
            } else {
                pre.next = right;
                right = right.next;
            }
            pre = pre.next;
        }
        pre.next = left == null ? right : left;
        return dummy.next;
    }


    public static ListNode sortList2(ListNode head) {

        if (head == null) return head;
        ListNode cur = head;
        List<Integer> list = new LinkedList<>();
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        Collections.sort(list);
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        dummy.next = head;
        for (Integer value : list) {
            pre.next = new ListNode(value);
            pre = pre.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
        ListNode node1 = sortList(node);
        System.out.println(node1);
    }
}
