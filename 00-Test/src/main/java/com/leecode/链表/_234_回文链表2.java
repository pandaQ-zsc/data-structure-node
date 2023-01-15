package com.leecode.链表;

import java.util.ArrayList;
import java.util.List;

public class _234_回文链表2 {
    //1 找到前半部分链表的尾节点。
    //2 反转后半部分链表。
    //3 判断是否回文。
    //4 恢复链表。
    //5 返回结果。
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
       ListNode fast = head.next;
       ListNode slow = head;
       while(fast!= null && fast.next!=null){
           fast = fast.next.next;
           slow = slow.next;
       }
       ListNode rHead = slow.next;
       slow.next = null;
       rHead = reverse(rHead);
       while(rHead!=null){
           if (head.val != rHead.val)
               return  false;
               head = head.next;
               rHead = rHead.next;

       }
       return true;
    }

    private ListNode reverse(ListNode rHead) {
        ListNode prev = null;
        ListNode cur = rHead;
        while(cur!= null){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;

    }

    // 迭代法求解反转链表--Leet206
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur.next;   // 用来存储之前cur的下一个节点，方便往后移动
            cur.next = prev;  // 之前的连接关系不再存在，变成这个新的
            // 往后移动
            prev = cur;
            cur = temp;  // 此时的cur.next已经变了，故要使用之前暂存的temp
        }
        return prev;  // 此时的反转后的新链表的头节点变为了prev
    }

}
