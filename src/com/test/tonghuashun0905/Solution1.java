package com.test.tonghuashun0905;

import com.offer.sword.ListNode;
import com.offer.util.LinkedListUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public ListNode addTwoNumbers(ListNode l1 , ListNode l2){
        long tempL1 = 0;
        if( l1 != null )
            tempL1 = convertNumbers(l1);
        long tempL2 = 0;
        if( l2 != null )
            tempL2 = convertNumbers(l2);
        long res = tempL1+tempL2;
        return convertLinkedList(res);
    }

    private ListNode convertLinkedList(long res) {
        ListNode p = null , q = null;
        while(res != 0){
            p = new ListNode((int)res % 10);
            p.next = q;
            q = p;
            res /= 10;
        }
        return p;
    }

    private long convertNumbers(ListNode l2) {
        ListNode p = l2;
        long res = 0;
        while(p!=null){
            res = res * 10 + p.val;
            p = p.next;
        }
        return res;
    }
}
