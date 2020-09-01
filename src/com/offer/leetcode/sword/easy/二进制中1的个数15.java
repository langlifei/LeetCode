package com.offer.leetcode.sword.easy;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/7 19:38
 * @Describe 注意:判断条件为！=0,因为可能出现符号位被更换，故大于0可能导致边界值无法通过。
 */

public class 二进制中1的个数15 {

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
            n = n&(n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(Integer.MAX_VALUE));
    }
}
