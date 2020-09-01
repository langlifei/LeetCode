package com.offer.leetcode.easy;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/4 23:11
 * @Describe
 */

class Easy01 {

    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null)
            return -1;
        if(needle.length() <= 0)
            return 0;
        int N = haystack.length();
        int L = needle.length();
        for(int i = 0 ; i < N-L+1 ; i++) //从0开始,需要加1
            if(haystack.substring(i,i+L).equals(needle))
                return i;
        return -1;
    }

    public static void main(String[] args) {
        Easy01 test = new Easy01();
        System.out.println(test.strStr("hello", "ll"));
    }
}
