package com.leecode.链表;

public class _147_对链表进行插入排序 {
    //插入排序：
    //插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
    //每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
    //重复直到所有输入数据插入完为止。
    //
    //输入: 4->2->1->3
    //输出: 1->2->3->4
    //
    //1->3->6->8->9->4例子中保证原本1,3 --> lastSorted->9 cur->4
    //TODO:链表一定要画图！！！


    public ListNode insertionSortList(ListNode head) {
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode sortedLast = head;
      ListNode cur = head.next;
      while(cur != null){
          if (sortedLast.val <= cur.val){
              sortedLast = sortedLast.next;
          }else {
              ListNode pre = dummy;
              while(pre.next.val<= cur.val){
                  pre = pre.next;
              }
              sortedLast.next = cur.next;
              cur.next = pre.next;
              pre.next = cur;
          }
          cur = sortedLast.next;
      }
      return dummy.next;
    }
}
