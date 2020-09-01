package com.offer.leetcode.medium;

import com.offer.sword.ListNode;

/**
 * @Author Zeng Zhuo
 * @Date 2020/5/30 14:47
 * @Describe
 */

public class 删除链表的倒数第N个节点19 {

    /**
     * 思路： 快慢指针法：
     *        1.先让p1前进N个节点。
     *        2.p2和p1一起前进
     *        3.p1遍历到链底时，p2指向倒数第N+1个节点。
     *
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode myHead = new ListNode(0);
        myHead.next = head;
        ListNode p1 = null,p2 = null, pre = myHead;
        //指向链表中第一个结点。
        p1 = myHead.next;
        p2 = myHead.next;
        while(p1 != null){
            //先让p1走n个节点
            if(n>0){
                p1 = p1.next;
                n--;
                continue;
            }
            p1 = p1.next;
            pre = p2;
            p2 = p2.next;
        }
        //删除目标节点。
        pre.next = p2.next;
        return myHead.next;
    }

    public static void main(String[] args) {
        删除链表的倒数第N个节点19 test = new 删除链表的倒数第N个节点19();
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        ListNode t = test.removeNthFromEnd(head,1);
        System.out.println(t.val);
    }
}
