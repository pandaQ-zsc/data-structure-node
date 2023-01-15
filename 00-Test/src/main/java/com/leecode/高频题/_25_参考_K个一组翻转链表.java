package com.leecode.高频题;

import com.leecode.链表.ListNode;

//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
//递归
//https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/di-gui-java-by-reedfan-2/
//迭代
//https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
public class _25_参考_K个一组翻转链表 {
    //1、找到待翻转的k个节点（注意：若剩余数量小于 k 的话，则不需要反转，因此直接返回待翻转部分的头结点即可）。
//2、对其进行翻转。并返回翻转后的头结点（注意：翻转为左闭又开区间，所以本轮操作的尾结点其实就是下一轮操作的头结点）。
//3、对下一轮 k 个节点也进行翻转操作。
//4、将上一轮翻转后的尾结点指向下一轮翻转后的头节点，即将每一轮翻转的k的节点连接起来。
//
    //head = dummy.next :找链表长度的时候使用了 head=head.next; 他已经不是原来的head了。
    //递归
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        // // 反转前 k 个元素
        ListNode newHead = reverse(head, tail);
        //下一轮的开始的地方就是tail
        head.next = reverseKGroup(tail, k);
        return newHead;
    }
    //迭代写法  --滑动窗口思想  一部分区域 一部分区域的反转
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while(end.next!=null){
            for (int i = 0; i <k && end !=null ; i++) {
                end = end.next;
            }
            if (end == null) break;
            ListNode newStart = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = myReverse(newStart);
            //反转后 连接上
            newStart.next = next;
            pre = newStart;
            end = newStart;
        }
        return dummy.next;
    }

    private ListNode myReverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }


    //左闭右开
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        while (head != tail) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

}
