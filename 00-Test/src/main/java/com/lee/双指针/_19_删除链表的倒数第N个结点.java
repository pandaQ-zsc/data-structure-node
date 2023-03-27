package com.lee.双指针;

import com.lee.链表.ListNode;

import java.util.ArrayList;

public class _19_删除链表的倒数第N个结点 {
    //输入：head = [1,2,3,4,5], n = 2
    //输出：[1,2,3,5]
    //头结点是1 ,dummy.next = head  head.val = 1

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            list.add(cur);
            cur = cur.next;
        }
        int target = list.size() -n;
        if (target == 0 ){
            if (head != null) {
            return head.next;
            }
        }
        ListNode pre = list.get(target-1);
        pre.next = pre.next.next;
        return head;
    }
}
