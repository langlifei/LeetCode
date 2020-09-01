package com.offer.sword;


/*
*                               时间:2020年3月8日11:42:29
*                               地点:湖北省仙桃市
*                               问题:输入两个单调递增的链表，输出两个链表合成后的链表，
*                                    当然我们需要合成后的链表满足单调不减规则。
*                               结果:通过.
*                               注:别忘了把没比完的节点,连接上去.
* */
public class Merge14 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null)
            return list2;
        else if(list2 == null)
            return list1;
        else if(list1==null&&list2==null)
            return null;
        ListNode head = null;
        ListNode p = list1;
        ListNode q = list2;
        //将两个链表中小的头节点赋给head;
        if(p.val < q.val){
            head = p;
            p = p.next;
        }else{
            head = q;
            q = q.next;
        }
        ListNode f = head;
        while(p!=null&&q!=null){
            if(p.val<q.val){
                f.next = p;
                p = p.next;
                f = f.next;
            }else{
                f.next = q;
                q = q.next;
                f = f.next;
            }
        }
        //将没比完剩下的链连接起来.
        if(p!=null)
            f.next = p;
        if(q!=null)
            f.next = q;
        return head;
    }
}
