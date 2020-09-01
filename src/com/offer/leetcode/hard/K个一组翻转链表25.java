package com.offer.leetcode.hard;

import com.offer.sword.ListNode;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/3 15:25
 * @Describe
 */

public class K个一组翻转链表25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)
            return null;
        ListNode myHead = new ListNode();
        myHead.next = head;
        ListNode pre = myHead;
        int count = 0;
        ListNode second = pre;
        while(count<k&&second!=null){
            second = second.next;
            count++;
        }
        if(second==null||second.next==null)
            return myHead.next;
        do{
            if(count==k){
                swap(pre,second);
                count=0;
            }
            count++;
            pre = pre.next;
            second = second.next;
        }while(second.next!=null);
        return myHead.next;
    }

    public void swap(ListNode first,ListNode second){
        //分别指向两个目标结点的前结点
        ListNode p = first.next;
        first.next = second.next;
        ListNode temp = second.next.next;
        second.next = p;
        first.next.next = p.next;
        p.next = temp;
    }
}
