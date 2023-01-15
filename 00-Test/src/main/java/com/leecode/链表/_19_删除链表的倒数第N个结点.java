package com.leecode.链表;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class _19_删除链表的倒数第N个结点 {
    //输入：head = [1,2,3,4,5], n = 2
    //输出：[1,2,3,5]
    //头结点是1 ,dummy.next = head  head.val = 1

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> arr = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            arr.add(cur);
            cur = cur.next;
        }
        int target = arr.size()-n;
        if (target == 0){
            if (head !=null){
                return head.next;
            }
        }
        ListNode pre = arr.get(target-1);
        pre.next = pre.next.next;
        return head;
    }
}
