package com.leecode.链表;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class _24_两两交换链表中的节点 {
    //输入：head = [1,2,3,4]
    //输出：[2,1,4,3]


    //迭代
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1), prev = dummy;
        dummy.next = head;
        while(prev.next != null && prev.next.next !=null){
            ListNode l1 = prev.next;
            ListNode l2 = prev.next.next;
            //三步交换
            l1.next = l2.next;
            l2.next =l1;
            //完成p -> l2  后变成 p ->l2 -> l1
            prev.next = l2;
            //p ->l2 -> l1  所以 prev 变成l1;
            prev = l1;
        }
        return dummy.next;

    }

    //递归

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        // 1 2 3 4
        // 先保存节点2
        ListNode tmp = head.next;
        //继续递归  处理节点 3 -> 4
        //当递归结束返回后， 就变成了 4 -> 3
        //于是head 节点就指向了4  变成了 1 -> 4 -> 3
        head.next = swapPairs(tmp.next);
        //将2节点指向1
        tmp.next = head;
        return tmp;
    }


    public ListNode swapPairs6(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode tmp = head.next;
         head.next = swapPairs(tmp.next);
         tmp.next = head;
         return tmp;
    }
}
