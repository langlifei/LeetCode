package com.offer.Sorts;

/**
 * 思想：冒泡比相邻，重者往下沉。
 * 特点：每趟排序可以确定一个元素的最终位置。
 * 复杂度：[o(n^2),o(1),稳定]
 */
public class BubbleSort implements Sort{

    @Override
    public void sort(int[] array) {
        boolean flag;//如果查一遍发现都已有序，则数组已经有序。
        int temp;
        for(int i = 0 ; i < array.length;i++){
            flag = false;
            for(int j = 0;j<array.length-i-1;j++){//-1是为了防止j+1超出下标范围，-i是因为从右数i个已经排好序了。
                if(array[j]>array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag)
                break;
        }
    }

}
