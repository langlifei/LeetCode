package com.offer.leetcode.sword.easy;

import com.offer.sword.ListNode;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/13 14:26
 * @Describe
 */

public class 反转链表24 {

    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode p = head.next;
        head.next = null;
        ListNode q = null;
        while(p!=null){
            q = p.next;
            p.next = head;
            head = p;
            p = q;
        }
        return head;
    }
}
