package com.test.shuidi0926;

import com.offer.sword.ListNode;

public class Test01 {

    static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;
        //采用快慢指针的思想
        ListNode myHead = new ListNode(0);//生成一个头结点
        ListNode pre = myHead;
        pre.next = head; //慢指针
        ListNode p = head; //快指针
        while(n > 0 && p != null){
            p = p.next;
            n--;
        }
        //两个指针一起走,当快指针走到链尾时,慢指针指向倒数第N+1个结点
        while( p != null){
            p = p.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return myHead.next;
    }
}
