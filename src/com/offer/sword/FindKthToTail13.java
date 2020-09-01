package com.offer.sword;

/*
                        时间:2020年3月8日10:45:10
                        地点:湖北省仙桃市
                        问题:输入一个链表，输出该链表中倒数第k个结点。
                        结果:通不过,原因,链表的倒链没有实现,并且更改了原链表的使用,导致其无法再次使用.
                        思路:通过统计节点个数,用总数-k可算出该节点从左到右的位置.


*/

public class FindKthToTail13 {

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode list = head;
        int count = 0;
        while(list!=null){
            count++;
            list = list.next;
        }
        if(count < k)
            return null;
        ListNode p = head;
        for(int i = 0; i < count-k;i++){
            p = p.next;
        }
        return p;
    }
}
