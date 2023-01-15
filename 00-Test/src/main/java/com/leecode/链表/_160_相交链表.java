package com.leecode.链表;

public class _160_相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode curA = headA, curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
            //这里有坑 下面为错误， 会一直拼接
//          //如果用.next会一直死循环（如果不相交）。
            // 因为不会存在curA和curB同时为null  每次要变成null的时候都变成了headA /headB
//          不用next，最后不相交的话会都等于None而结束循环
//            curA = curA.next == null? headB : curA.next;
//            curB = curB.next == null? headA : curB.next;            curA = curA.next == null? headB : curA.next;
        }
        return curA;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode curA =headA;
        ListNode curB = headB;
        while(curA != curB){
           curA = curA == null ? headB : curA.next;
           curB = curB == null ? headA : curB.next;
        }
        return curA;

    }
}
