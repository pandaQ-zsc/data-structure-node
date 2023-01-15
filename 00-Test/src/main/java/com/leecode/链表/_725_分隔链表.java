package com.leecode.链表;

import java.util.ArrayList;
import java.util.List;

public class _725_分隔链表 {
    //root = [1, 2, 3], k = 5
    //输出: [[1],[2],[3],[],[]]
    //root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
    //输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        //rem 代表还有几个数组需要宽度+1
        int width = count / k, rem = count % k;
        ListNode[] res = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; ++i) {
            ListNode pre = new ListNode(0), write = pre;
            //(i < rem ? 1 : 0)  很关键，第i个数组(0,k-1) 是否小于余数(1,k)
            for (int j = 0; j < width + (i < rem ? 1 : 0); j++) {
                write.next = new ListNode(cur.val);
                write = write.next;
                cur = cur.next;
            }
            res[i] = pre.next;
        }
        return res;
    }

    public ListNode[] splitListToParts2(ListNode root, int k) {
        ListNode cur = root;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        int width = count / k, rem = count % k;
        cur = root;
        ListNode[] res = new ListNode[k];
        for (int i = 0; i < k; ++i) {
            ListNode pre = new ListNode(0);
            ListNode tmp = pre;
            for (int j = 0; j < width + (i < rem ? 1 : 0); ++j) {
                tmp.next = new ListNode(cur.val);
                tmp = tmp.next;
                cur = cur.next;
            }
            res[i] = pre.next;
        }
        return res;
    }
}

