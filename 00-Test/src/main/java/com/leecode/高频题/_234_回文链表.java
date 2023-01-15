package com.leecode.高频题;

import com.leecode.链表.ListNode;

import java.util.ArrayList;
import java.util.List;

public class _234_回文链表 {
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        List<Integer> list = new ArrayList<>();
        while(cur != null){
            list.add(cur.val);
            cur =cur.next;
        }
        int l =0;
        int r = list.size()-1;
        while(l < r){
            if (!list.get(l).equals(list.get(r))){
                return false;
            }else {
                l++;
                r--;
            }
        }
        return true;
    }
}
