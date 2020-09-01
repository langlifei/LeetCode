package com.offer.codingInterviewGuide.LinkedList;

import com.offer.util.LinkedListUtil;
import com.offer.sword.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/18 21:50
 * @Describe
 */

class LinkedList03 {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        if(head.next==null)
            return head;
        ListNode p = head;
        while(p.next!=null)
            p = p.next;
        reverse(head);
        return p;
    }

    public ListNode reverse(ListNode head){
        if(head == null)
            return null;
        if(head.next==null)
            return head;
        ListNode next = head.next;
        head.next = null;
        ListNode p = reverse(next);
        p.next = head;
        return head;
    }

    public static void main(String[] args) {
        List list = Arrays.asList(1,2,3,4,5);
        ListNode head = LinkedListUtil.createLinkedList(list);
        LinkedList03 test = new LinkedList03();
        test.reverseList(head);
    }
}
