package com.leecode.链表;

public class _86_分隔链表 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return  null;
        ListNode lHead = new ListNode(0);
        ListNode rHead = new ListNode(0);
        ListNode lTail = lHead;
        ListNode rTail = rHead;
        while(head != null){
            if (head.val < x){
                lTail.next = head;
                lTail = head;
            }else {
                rTail.next = head;
                rTail = head;
            }
            head = head.next;
        }

        lTail.next =  lHead.next;
        rTail.next = null;
        return lHead.next;
     }
}
