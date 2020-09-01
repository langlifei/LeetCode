package com.offer.sword;


/*
*                           时间:2020年3月7日10:46:48
*                           地点:湖北省仙桃市
*                           问题:输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
*                                使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后
*                                半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
*                           通过率:100%
* */

public class Power11 {

    public double Power(double base, int exponent) {
        if(base < 0.00000001 && base > - 0.00000001)
            return -1;
        if(exponent == 0)
            return 1;
        if(exponent < 0)
            return 1/f(-exponent,base);
        return f(exponent,base);
    }

    public double f(double base, int exponent){
        if(exponent == 0)
            return 1;
        else
            return base*f(base,exponent-1);
    }

    public double f(int exponent,double base){
        double temp = base;
        while(exponent > 1){
            temp = base*temp;
            exponent--;
        }
        return temp;
    }


    public static void main(String[] args){
        Power11 p = new Power11();
        System.out.println(p.Power(2,-3));
    }
}
