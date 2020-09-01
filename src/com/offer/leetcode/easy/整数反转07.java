package com.offer.leetcode.easy;

/**
 *              时间:2020年4月13日11:13:47
 *              题解:1.可以通过x*10/10来判断如果继续翻转是否会发生溢出
 *                   2.如果不会,那么加余数0~9也固然不会溢出.
 */

public class 整数反转07 {

    public int reverse(int x){
        if(x>0)
            return f(x);
        else if(x==0)
            return x;
        else
            return -f(-x);
    }

    public int f(int x){
        int m = 0;
        int n = 0;
        while(x!=0){
            m = x % 10;
            n = n*10+m;
            x/=10;
        }
        return n;
    }

    /**
     *
     * @param x
     * @return
     */
    public int reverse2(int x) {
        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }
}
