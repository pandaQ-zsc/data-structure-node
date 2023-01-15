package com.leecode.链表;


import java.util.PriorityQueue;

//输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
public class _剑指Offer_难_078_合并排序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode head : lists){
            if (head!= null) queue.offer(head);
        }
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        while(!queue.isEmpty()){
            ListNode cur = queue.poll();
            prev.next = cur;
            if (cur.next != null) queue.offer(cur.next);
//            prev = prev.next;
              prev = cur;
              cur.next = null;
        }
        return dummy.next;

    }
}
