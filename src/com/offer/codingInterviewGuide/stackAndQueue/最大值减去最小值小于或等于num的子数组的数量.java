package com.offer.codingInterviewGuide.stackAndQueue;

import java.util.LinkedList;

/**
 * @Author Zeng Zhuo
 * @Date 2020/7/19 11:01
 * @Describe 利用队列来记录滑动窗口中的最值
 */

class Queue1 {

    public int getNum(int[] arr,int num){
        LinkedList<Integer> qMax = new LinkedList<>();
        LinkedList<Integer> qMin = new LinkedList<>();
        int sum = 0;
        int i = 0 , j = 0;
        while( i < arr.length){
            while(j < arr.length){
                //存入最大值(倒序)
                while(!qMax.isEmpty()&&arr[qMax.peekLast()]<=arr[j])
                    qMax.pollLast();
                qMax.add(j);
                //存入最小值(升序)
                while(!qMin.isEmpty()&&arr[qMax.peekLast()]>=arr[j])
                    qMin.pollLast();
                qMin.add(j);
                if(arr[qMax.peekFirst()]-arr[qMin.peekFirst()]>num)
                    break;
                j++;
            }
            //移动i之前,对qMax,qMin进行更新，防止取到窗口之外的值
            if(qMax.peekFirst()==i)
                qMax.pollFirst();
            if(qMin.peekLast()==i)
                qMin.pollFirst();
            sum+=j-i;
            i++;
        }
        return sum;
    }
}
