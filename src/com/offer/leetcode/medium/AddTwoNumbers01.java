package com.offer.leetcode.medium;

import com.offer.sword.ListNode;

/*
*                       时间：2020年3月11日20:52:25
*                       地点：湖北省仙桃市
*                       问题：给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
                              如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
                        结果：(3ms);(41.1MB)
                        题解：可将标记用一个0和1的变量代替，减少运行时间。
* */

public class AddTwoNumbers01 {

    /**
     * @result (2ms,99.98%);(41.5mb,93.42%)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        int flag = 0;
        ListNode list = l1;
        ListNode p = null;
        while(l1!=null&&l2!=null){
            p = l1;
            p.val = l1.val+l2.val;
            //如果进位了则加1
            p.val+=flag;
            //重置
            flag = 0;
            //查看是否产生进位
            if(p.val>=10){
                p.val = p.val % 10;
                flag = 1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1==null){
            p.next = l2;
        }
        //是否有进位未处理
        if(p.next!=null){
            p = p.next;
            p.val+=flag;
        }else if(p.next==null&&flag==1)
            p.next = new ListNode(1);
        //防止9999+1这种情况。
        while(p.val>=10&&p.next!=null){
            p.val = p.val % 10;
            p=p.next;
            p.val+=1;
        }
        if(p.val>=10&&p.next==null){
            p.val = p.val % 10;
            p.next = new ListNode(1);
        }
        return list;
    }

    /**
     * @ result (2ms);(41mb)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(9);
        ListNode p = l1;
        for(int i = 0 ; i < 4;i++)
        {
            p.next = new ListNode(9);
            p = p.next;
        }
        ListNode l2 = new ListNode(1);
        AddTwoNumbers01 obj = new AddTwoNumbers01();
        obj.addTwoNumbers1(l1,l2);
    }
}
