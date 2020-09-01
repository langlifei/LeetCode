package com.offer.codingInterviewGuide.binTree;

import com.offer.util.LinkedListUtil;
import com.offer.sword.ListNode;
import com.offer.sword.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/18 10:02
 * @Describe
 */

class Tree02 {
    public TreeNode sortedListToBST(ListNode head) {
        if( head == null )
            return null;
        if(head != null && head.next==null) //只有一个结点时直接返回,否则会造成死循环导致栈溢出
            return new TreeNode(head.val);
        ListNode p = head;
        ListNode q = head;
        ListNode pre = p;
        while(q != null && q.next != null){
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;
        q = p.next;
        p.next = null;
        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(q);
        return root;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-10, -3, 0, 5, 9);
        ListNode head = LinkedListUtil.createLinkedList(list);
        Tree02 test = new Tree02();
        test.sortedListToBST(head);
    }
}
