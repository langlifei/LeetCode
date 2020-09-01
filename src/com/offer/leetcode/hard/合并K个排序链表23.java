package com.offer.leetcode.hard;

import com.offer.leetcode.easy.合并两个有序链表21;
import com.offer.sword.ListNode;

/**
 * @Author Zeng Zhuo
 * @Date 2020/5/31 9:56
 * @Describe
 */

public class 合并K个排序链表23 {


    public ListNode mergeKLists(ListNode[] lists) {
        合并两个有序链表21 test = new 合并两个有序链表21();
        ListNode p = null;
        for (int i = 0 ; i < lists.length;i++){
            p =  test.mergeTwoLists(p,lists[i]);
        }
        return p;
    }
}
