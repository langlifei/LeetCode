package com.offer.util;

import com.offer.sword.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/18 10:39
 * @Describe
 */

public class LinkedListUtil<E> {

    public static ListNode createLinkedList(List<Integer> list){
        if(list == null || list.size() <= 0)
            return null;
        ListNode head = new ListNode(list.get(0));
        ListNode p = head;
        for(int i = 1 ; i < list.size(); i++){
            p.next = new ListNode(list.get(i));
            p = p.next;
        }
        return head;
    }
}
