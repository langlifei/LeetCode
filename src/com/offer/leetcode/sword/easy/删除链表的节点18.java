package com.offer.leetcode.sword.easy;

import com.offer.sword.ListNode;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/13 16:33
 * @Describe
 */

public class 删除链表的节点18 {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null)
            return null;
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode p = head;
        head = pre;
        while(p!=null){
            if(p.val==val){
                pre.next = p.next;
                return head.next;
            }
            p = p.next;
            pre = pre.next;
        }
        return head.next;
    }
}
