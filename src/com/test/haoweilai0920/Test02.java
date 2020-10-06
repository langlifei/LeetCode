package com.test.haoweilai0920;

import com.offer.sword.ListNode;

public class Test02 {


    public ListNode reverseList (ListNode head) {
        if(head==null)
            return null;
        ListNode p = head;
        ListNode q = null,temp = null;
        while(p!=null){
            q = p.next;
            p.next = temp;
            temp = p;
            p = q;
        }
        return temp;
        // write code here
    }

    public ListNode reverseList1 (ListNode head) {
        if(head!=null && head.next==null)
            return head;
        ListNode p = head.next;
        ListNode q = null,temp = null;
        while(p!=null){
            q = p.next;
            p.next = temp;
            temp = p;
            p = q;
        }
        head.next = temp;
        return head;
        // write code here
    }
}
