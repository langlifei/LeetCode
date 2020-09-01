package com.offer.codingInterviewGuide.LinkedList;

import com.offer.sword.ListNode;
import netscape.security.UserTarget;

import java.util.Stack;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/25 16:47
 * @Describe
 */

class LinkedList05 {

    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return false;
        Stack<Integer> stack = new Stack<>();
        ListNode pA = head;
        ListNode pB = head;
        while( pB != null && pB.next != null){
            stack.push(pA.val);
            pA = pA.next;
            pB = pB.next.next;
        }
        //链表长度为奇数,所以向下走一步
        if( pB!=null && pB.next==null)
            pA = pA.next;
        while(!stack.isEmpty() && pA!=null){
            if(stack.pop() != pA.val)
                return false;
            pA = pA.next;
        }
        return true;
    }
}
