package com.offer.leetcode.sword.easy;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/13 15:24
 * @Describe
 */

public class 打印从1到最大的n位数17 {
    public int[] printNumbers(int n) {
        int m = 0;
        while(n>0){
            m = m*10+9;
            n--;
        }
        int[] temp = new int[m];
        for(int i = 0 ; i < temp.length;i++)
            temp[i] = i+1;
        return temp;
    }
}
