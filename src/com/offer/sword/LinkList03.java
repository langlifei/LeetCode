package com.offer.sword;

import java.util.ArrayList;

/*
*                           时间:2020年3月5日13:42:58
*                           地点:湖北省仙桃市
*                           问题:输入一个链表，按链表从尾到头的顺序返回一个ArrayList.
*                           通过率:100%
* */

public class LinkList03 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode list = listNode;
        ArrayList<Integer> arrayList = new ArrayList<>();
        //当节点不空时向ArrayList中填入数
        while(list != null){
            arrayList.add(list.val);//将当前节点中的值存入数组
            list = list.next;//向下一个节点遍历
        }
        //对arraylist数组中的元素置反
        Integer temp = null;
        for(int i = 0 , j = arrayList.size()-1;i<j;i++,j--){
            temp = arrayList.get(i);
            arrayList.set(i,arrayList.get(j));
            arrayList.set(j,temp);
        }
        return arrayList;
    }
}
