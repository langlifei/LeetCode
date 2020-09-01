package com.offer.codingInterviewGuide.LinkedList;

import com.offer.sword.ListNode;
import com.offer.util.LinkedListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/25 14:43
 * @Describe
 */

class LinkedList04 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if( headA == null || headB == null )
            return null;
        int countA = 0;
        int countB = 0;
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA.next != null){
            countA++;
            pA = pA.next;
        }
        while(pB.next != null){
            countB++;
            pB = pB.next;
        }
        while(countA>countB && headA.next != null)
            headA = headA.next;
        while(countB>countA && headB.next != null)
            headB = headB.next;
        while(countB > 0 && headA != headB && headA != null && headB != null){
            headA = headA.next;
            headB = headB.next;
            countB--;
        }
        if(countB > 0 && headB == headA && headA != null)
            return headA;
        else
            return null;
    }

    public static void main(String[] args) {
        LinkedList04 test = new LinkedList04();
        ListNode headA = LinkedListUtil.createLinkedList(Arrays.asList(4,1,8,4,5));
        ListNode headB = LinkedListUtil.createLinkedList(Arrays.asList(5,6,1,8,4,5));
        System.out.println(test.getIntersectionNode(headA, headB));
    }
}
