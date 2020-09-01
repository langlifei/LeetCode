package com.offer.leetcode.sword.easy;

import com.offer.sword.ListNode;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/13 10:29
 * @Describe 采用快慢指针的思想
 */

public class 链表中倒数第k个节点22 {

    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode p = head;
            ListNode q = head;
            while(k>0&&q!=null){
                q = q.next;
                k--;
            }
            while(q!=null){
                q = q.next;
                p = p.next;
            }
            return p;
        }
    }
}
