package com.test.genwoxue0923;

import com.offer.sword.ListNode;
import com.offer.util.LinkedListUtil;

public class Test02 {


    static ListNode getCommon(ListNode headA, ListNode headB) {
        if(headA==null || headB == null)
            return null;
        boolean qFirst = true;
        boolean pFirst = true;
        ListNode p = headA;
        ListNode q = headB;
        while(p != null && q != null){
            if(p==q)
                return p;
            p = p.next;
            q = q.next;
            if(qFirst&&q==null){
                q = headA;
                qFirst = false;
            }
            if(pFirst&&p==null){
                p = headB;
                pFirst = false;
            }
        }
        return null;
    }
}
