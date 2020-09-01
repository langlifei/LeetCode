package com.offer.leetcode.sword.medium;

import com.offer.leetcode.sword.Node;
import com.offer.sword.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/13 16:57
 * @Describe 1.在节点后面复制一个相同的节点
 *           2.根据相对位置设置随机指针的指向
 *           3.分离复制的结点
 */

public class 复杂链表的复制35 {
    public Node copyRandomList(Node head) {
        Node p = head;
        Node temp;
        while(p!=null){
            temp = new Node(-1);
            temp.val = p.val;
            temp.next = p.next;
            p.next = temp;
            p = temp.next;
        }
        Node newHead = new Node(-1);
        Node q = newHead;
        p = head;
        while(p!=null&&p.next!=null){
            q.next = p.next;
            if(p.random!=null)
                q.next.random = p.random.next;
            else
                q.next.random = null;
            q = q.next;
            p = p.next.next;
        }
        return newHead.next;
    }
}
