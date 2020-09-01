package com.offer.sword;

/*
*                   时间:2020年3月8日11:15:10
*                   地点:湖北省仙桃市
*                   结果:通过
*                   思想:至少有两个节点才能反转,从第二个开始向前反指,第一个节点指向空
*                        注:需要使用临时变量记录链表的后链,以防丢链.
* */

public class ReverseList13 {
    public ListNode ReverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode p = head;
        ListNode l1 = p.next, l2 = null;
        p.next = null;
        while(l1!=null){
            l2 = l1.next;
            l1.next = p;
            p = l1;
            l1 = l2;
        }
        return p;
    }
}
