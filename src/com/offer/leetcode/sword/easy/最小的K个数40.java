package com.offer.leetcode.sword.easy;

import com.offer.sword.ListNode;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/13 19:46
 * @Describe
 */

public class 最小的K个数40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == arr.length)
            return arr;
        if(k==0)
            return new int[0];
        int[] temp = new int[k];
        for(int i = 0 ; i < temp.length;i++)
            temp[i] = Integer.MAX_VALUE;
        for(int i = 0; i<arr.length;i++){
            f(arr[i],temp);
        }

        return temp;
    }

    private void f(int target, int[] temp) {
        int k = temp.length-1;
        if(temp[k]<target){
            return;
        }
        while(k>0){
            if(temp[k]>target){
                temp[k] = temp[k-1];
                k--;
            }else
                break;
        }
        temp[k] = target;
    }

}
