package com.lee.asia;

import com.lee.链表.ListNode;

import java.util.*;

//https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/23ti-he-bing-kge-pai-xu-lian-biao-by-iceblood/

//输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
//
public class _23_合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        List<Integer> list = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }
        }
        int[] tempArray = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            tempArray[i] = list.get(i);
//        }
        int i = 0;
        while (list.size() > 0) {
            tempArray[i++] = list.remove(0);
        }
        Arrays.sort(tempArray);
        String s = Arrays.toString(tempArray);
        System.out.println("tempArray ==>" + s);
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int temp : tempArray) {
            cur.next = new ListNode(temp);
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (!queue.isEmpty()) {
//            ListNode poll = queue.poll();
//            while (poll.next != null){
//                pre.next = poll.next;
//                pre = pre.next;
//            }
            ListNode poll = queue.poll();
            pre.next = poll;
            pre = pre.next;
            if (poll.next != null) {
                queue.offer(poll.next);
            }
        }
        return dummy.next;
    }

    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            prev.next = poll;
            prev = prev.next;
            if (poll.next != null) {
                queue.offer(poll.next);
            }
        }
        return dummy.next;
    }

}

