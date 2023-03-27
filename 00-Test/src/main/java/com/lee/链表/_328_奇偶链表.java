package com.lee.链表;

public class _328_奇偶链表 {
    //输入: 1->2->3->4->5->NULL
    //输出: 1->3->5->2->4->NULL
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head, evenHead = head.next, even = evenHead;
        //全部节点分离完毕的条件是even为空节点或者
        // even.next为空节点,此时odd执行最后一个技术节点
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode evenHead = head.next, even = evenHead;
        while(even != null && even.next !=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even =even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
