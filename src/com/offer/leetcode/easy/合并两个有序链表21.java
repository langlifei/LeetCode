package com.offer.leetcode.easy;

import com.offer.sword.ListNode;

/**
 * @Author Zeng Zhuo
 * @Date 2020/5/30 18:23
 * @Describe key:此题可使用分治法，可参考归并排序的思想
 */

public class 合并两个有序链表21 {

    /**
     * 此方法时间复杂度比较高
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode p = null;
        for(int i = 0 ; i < lists.length;i++)
            p = mergeTwoLists(p,lists[i]);
        return p;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode l = null;
        if(l1.val<l2.val){
            l = l1;
            l1 = l1.next;
        }
        else{
            l = l2;
            l2 = l2.next;
        }
        ListNode q = l,p1 = l1,p2=l2;
        while(p1!=null&&p2!=null){
            if(p1.val<p2.val){
                q.next = p1;
                p1 = p1.next;
            }else{
                q.next = p2;
                p2 = p2.next;
            }
            q = q.next;
        }
        if(p1==null)
            q.next = p2;
        if(p2==null)
            q.next = p1;
        return l;
    }
}
