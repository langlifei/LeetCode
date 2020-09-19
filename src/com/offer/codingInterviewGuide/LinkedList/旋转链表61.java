package com.offer.codingInterviewGuide.LinkedList;

import com.offer.sword.ListNode;

class LinkedList{

    public ListNode rotateRight(ListNode head, int k) {
        if( head == null || k <= 0)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        int temp = k;
        while(temp>0 && fast!=null){
            fast = fast.next;
            count++;
            temp--;
        }
        if( temp > 0 ){
            temp %= count;
            fast = head;
            while(temp>0 && fast!=null){
                fast = fast.next;
                temp--;
            }
        }
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        if(fast!=null)
            fast.next = head;
        return newHead;
    }
}
