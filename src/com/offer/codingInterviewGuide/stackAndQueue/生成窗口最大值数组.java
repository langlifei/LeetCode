package com.offer.codingInterviewGuide.stackAndQueue;

import java.util.LinkedList;

/**
 * @Author Zeng Zhuo
 * @Date 2020/7/16 19:24
 * @Describe 使用队列来存储移动窗口中先按先下标有序，后值有序的数据。
 */

class Queue01 {

    public int[] getMaxWindow(int[] arr,int w){
        if( arr == null || w < 1 || arr.length < w)
            return null;
        LinkedList<Integer> qMax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];//窗口的大小
        int index = 0;
        for(int i = 0 ; i < arr.length ; i++){
            //如果不等于空且队尾小于当前值，则移出队尾元素，保证队头是最大值
            while(!qMax.isEmpty()&&arr[qMax.peekLast()] <= arr[i])
                qMax.pollLast();
            qMax.addLast(i);
            //当队头不在移动窗口中是移除。
            //注：i 从 0 开始，所以是 i - w .如 i = 3 , w = 3 , 下标为0的元素已经不在移动窗口中。
            if( qMax.peekFirst() == i - w)
                qMax.pollFirst();
            //当前下标超出或等于窗口大小时,获取窗口中的最大值，即队列中的队头。等于是因为下标从0开始。
            if( i >= w-1)
                res[index++] = arr[qMax.peekFirst()]; // 由于最大值不一定在窗口的边界，所以只是获取并不移除。
        }
        return res;
    }
}
