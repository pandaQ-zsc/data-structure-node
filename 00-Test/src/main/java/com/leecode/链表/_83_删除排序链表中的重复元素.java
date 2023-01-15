package com.leecode.链表;

public class _83_删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while(node!=null && node.next !=null){
            if (node.val == node.next.val){
                node.next = node.next.next;
            }else { //如果没有else的话 容易出现
                    // 2 3333 1 3 4 这种中间存在大量重复数字的情况
                node = node.next;
            }
        }
        return head;
    }
}
