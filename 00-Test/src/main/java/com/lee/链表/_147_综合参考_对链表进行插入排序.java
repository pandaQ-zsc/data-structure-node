package com.lee.链表;

public class _147_综合参考_对链表进行插入排序 {
    //插入排序：
    //插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
    //每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
    //重复直到所有输入数据插入完为止。
    //
    //输入: 4->2->1->3
    //输出: 1->2->3->4

    //TODO:链表一定要画图！！！


    public ListNode insertionSortList(ListNode head) {
        // 1. 首先判断给定的链表是否为空，若为空，则不需要进行排序，直接返回。
        if(head == null){
            return head;
        }

        // 2. 链表初始化操作
        ListNode dummyHead = new ListNode(0); // 引入哑节点
        dummyHead.next = head;              // 目的是在head之前插入节点
        ListNode lastSorted = head;          //已排序链表的最后一个结点
        ListNode curr = head.next;           //待排序结点

        // 3. 插入排序
        while(curr != null){
            //1->3->6->8->9->4例子中保证原本1,3 --> lastSorted->9 cur->4
            if(lastSorted.val <= curr.val){    //无需排序, 因为待排序结点比前面所有的都大
                lastSorted = lastSorted.next;   // 将lastSorted后移一位,curr变成新的lastSorted
            }else{
                //否则, 需要从前往后找一个合适的位置来放入待排序结点curr
                ListNode prev = dummyHead;      // 从链表头开始遍历 prev是插入节点curr位置的前一个节点
                while(prev.next.val <= curr.val){ // 循环退出的条件是找到curr应该插入的位置
                    prev = prev.next;
                }
                //第一个出现比待排序结点curr大的结点, 直接放入待排序结点就好
                //比如1->3->6->8->9->4待排序结点为4, 则上面循环到prev->next->val = 6时退出
                // , 此时prev指向3
        //因为curr已被排序, 所以已排序链表的最后一个结点9,应该指向curr->next(未排序4的后面)
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next; // 此时 curr 为下一个待插入的元素
        }
        // 返回排好序的链表
        return dummyHead.next;
    }
}
