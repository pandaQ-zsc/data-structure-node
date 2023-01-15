package com.leecode.高频题;

import com.leecode.链表.ListNode;

public class _160_相交链表 {
    //pA:1->2->3->4->5->6->null->9->5->6->null
    //pB:9->5->6->null->1->2->3->4->5->6->null
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) return null;
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA != curB){
           if (curA == null){
               curA = headB;
           }else {
               curA = curA.next;
           }
           if (curB == null){
               curB = headA;
           }else {
               curB = curB.next;
           }
        }
        return curA;
    }
}
