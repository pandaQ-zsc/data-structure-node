package com.leecode.高频题;

import com.leecode.链表.ListNode;


public class _21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       ListNode dummy = new ListNode(0);
       ListNode pre = dummy;
       while(l1 != null && l2 != null){
           if (l1.val > l2.val){
               pre.next = l1;
               l1 = l1.next;
           }else {
               pre.next = l2;
               l2 = l2.next;
           }
           pre = pre.next;
       }
       if (l1 == null){
           pre.next = l2;
       }else {
           pre.next = l1;
       }
       return dummy.next;
    }
}
