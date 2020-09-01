package com.offer.codingInterviewGuide.LinkedList;

import com.offer.leetcode.sword.Node;

/**
 * @Author Zeng Zhuo
 * @Date 2020/7/19 16:41
 * @Describe  通过递归直接推导出最后一个存活的人,公式：old = (new + m -1) % i + 1
 */

class LinkedList01 {


    public Node josephusKill(Node head , int m){
        if(head == null || head.next == head || m < 1)
            return head;
        //统计个数
        int count = 1;
        Node cur = head.next;
        while(cur!=head){
            count++;
            cur = cur.next;
        }
        count = getLive(count,m);
        while(--count != 0){
            head = head.next;
        }
        head.next = head;//形成单节点的环形链表
        return head;
    }

    private int getLive(int i, int m) {
        if(i==1)
            return 1;
        else
            return ((getLive(i-1,m) + m - 1 ) % i -1);
    }
}
