package com.offer.leetcode.sword.easy;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/6 16:12
 * @Describe
 */

public class 斐波拉契数列10 {

    public int fib(int n) {
        int f0 = 0;
        int f1 = 1;
        int sum = 0;
        if(n<=0)
            return f0;
        if(n==1)
            return f1;
        while(n>=2){
            sum = (f0 + f1)%1000000007;
            f0 = f1;
            f1 = sum;
            n--;
        }
        return sum;
    }

    public static void main(String[] args) {
        斐波拉契数列10 test = new 斐波拉契数列10();
        System.out.println(test.fib(5));
    }
}
