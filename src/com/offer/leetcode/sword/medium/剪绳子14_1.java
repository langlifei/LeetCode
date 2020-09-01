package com.offer.leetcode.sword.medium;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/7 19:28
 * @Describe 当数值太大时，会超出界限范围，当取一次余解决不了时，采用循环取余法。
 */

public class 剪绳子14_1 {

    public int cuttingRope(int n) {
        if(n<=3)
            return n-1;
        int m = n/3;
        int p = n%3;
        if(p==1)
            return f(3,m-1,1000000007,4);
        else if(p==2)
            return f(3,m,1000000007,2);
        return f(3,m,1000000007,1);
    }

    public int f(int x , int a , int p,int m){
        long rem = 1;
        for(int i = 1 ; i <= a;i++){
            rem = (rem*x) % p;
        }
        rem = (rem*m) % p;
        return (int)rem;
    }
}
