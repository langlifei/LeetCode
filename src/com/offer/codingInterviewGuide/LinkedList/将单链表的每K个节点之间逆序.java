package com.offer.codingInterviewGuide.LinkedList;

import com.offer.leetcode.sword.Node;

import java.util.Stack;

/**
 * @Author Zeng Zhuo
 * @Date 2020/7/20 7:06
 * @Describe
 */

class LinkedList02 {

    public Node reverseKNode(Node head, int k){
        if(head == null || k < 2)
            return head;
        int count = 0 ;
        Node p = head;
        Node q = null;
        Node m = null;
        Stack<Node> stack = new Stack<>();
        while(p!=null){
            stack.push(p);
            p = p.next;
            count++;
            //栈中元素达到K个
            if(count==k){
                m = stack.peek();
                //对栈中元素进行逆转
                q = resign(stack);
                q.next = reverseKNode(q.next,k);
            }
        }
        return m;
    }

    private Node resign(Stack<Node> stack) {
        Node head = stack.pop();
        Node temp = head.next;
        while(!stack.isEmpty()){
            head.next = stack.pop();
            head = head.next;
        }
        head.next = temp;
        return head;
    }
}
