package com.offer.leetcode.medium;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/14 14:20
 * @Describe
 */

class Med01 {

    public int divide(int dividend, int divisor) {
        if(divisor==0 || dividend == 0)
            return 0;
        boolean isDownZero = false;
        if(dividend<0||divisor<0)
            isDownZero = true;
        return isDownZero?-compute(Math.abs(dividend),Math.abs(divisor)):compute(Math.abs(dividend),Math.abs(divisor));
    }

    private int compute(int dividend, int divisor) {
        int count = 0;
        while(dividend>divisor){
            count++;
            dividend-=divisor;
        }
        return count;
    }
}
