package com.leecode.双指针;

import com.leecode.链表.ListNode;

public class _142_环形链表II {
    public ListNode detectCycle(ListNode head) {
      ListNode fast = head;
      ListNode slow = head;
      while (true){
          fast = fast.next.next;
          slow = slow.next;
          if (fast == slow){
              break;
          }
      }
      fast = head;
      while(fast !=slow){
          fast = fast.next;
          slow = slow.next;
      }
      return fast;


    }

}
