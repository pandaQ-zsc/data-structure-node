package com.lee.双指针;

import com.lee.链表.ListNode;

import java.util.ArrayList;

//涉及到
// 【重要】反转链表(https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/)
public class _234_回文链表2 {
    public static boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        ArrayList<ListNode> list = new ArrayList<>();
        while (cur != null){
            list.add(cur);
            cur = cur.next;
        }
        int l = 0;
        int r = list.size()-1;
        while(l < r){
            if (list.get(l).val == list.get(r).val){
                l++;
                r--;
            }else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(3);
        System.out.println(head);
        isPalindrome(head);
        System.out.println(head);

    }
}

