package com.offer.leetcode.medium;

import com.offer.sword.ListNode;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/2 9:01
 * @Describe
 */

public class 两两交换链表中的节点24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next == null)
            return head;
        ListNode myHead = new ListNode();
        myHead.next = head;
        ListNode pre = myHead;
        ListNode p = myHead.next;
        while(p!=null&&p.next!=null){
            swap(pre);
            pre = pre.next.next;
            p = p.next;//由于已经被移到p.next，故只需再右移一次。
        }
        return myHead.next;
    }

    public void swap(ListNode head){
        ListNode p = head.next;
        ListNode q = p.next;
        head.next = q;
        p.next = q.next;
        q.next = p;
    }
}
