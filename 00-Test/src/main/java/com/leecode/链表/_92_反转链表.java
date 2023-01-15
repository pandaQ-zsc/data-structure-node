package com.leecode.链表;

public class _92_反转链表 {
    //https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/ji-bai-liao-100de-javayong-hu-by-reedfan-6/
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode node = res;
        //找到需要反转的那一段的上一个节点。
        for (int i = 1; i < m; i++) {
            node = node.next;
        }
        //node.next就是需要反转的这段的起点。
        ListNode nextHead = node.next;
        ListNode next = null;
        ListNode pre = null;
        //反转m到n这一段
        for (int i = m; i <= n; i++) {
            next = nextHead.next;
            nextHead.next = pre;
            pre = nextHead;
            nextHead = next;
        }
        //将反转的起点的next指向next。
        node.next.next = next;
        //需要反转的那一段的上一个节点的next节点指向反转后链表的头结点
        node.next = pre;
        return res.next;
    }
    public ListNode reverseBetween3(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = dummy;
        for (int i = 0; i < left-1; i++) {
            node = node.next;
        }
        ListNode headNext = node.next;
        ListNode prev = null;
        ListNode next = null;
        for (int i = left; i <=right ; i++) {
            next = headNext.next;
            headNext.next = prev;
            prev = headNext;
            headNext = next;
        }
        node.next.next = next;
        node.next = prev;
        return dummy.next;

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;
        pre.next=null;
        rightNode.next = null;
        reverseLinkedList(leftNode);
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    private void reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur !=null){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
    }


}
