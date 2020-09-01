package com.offer.leetcode.sword.easy;

import com.offer.sword.ListNode;

import java.util.Stack;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/7 12:52
 * @Describe
 */

public class 从尾到头打印链表06 {

    Stack<Integer> stack = new Stack<>();
    public int[] reversePrint(ListNode head) {
        int count = 0;
        while(head!=null){
            stack.push(head.val);
            count++;
            head = head.next;
        }
        int[] list = new int[count];
        int i = 0;
        while (!stack.empty()){
            list[i] = stack.pop();
            i++;
        }
        return list;
    }
}
