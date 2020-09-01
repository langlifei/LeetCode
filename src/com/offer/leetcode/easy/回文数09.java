package com.offer.leetcode.easy;

/**
 *              时间:2020年4月13日15:01:46
 *              题解:1.利用取余和除法来置反数字后,查看是否相等.
 */

public class 回文数09 {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        else{
            int k = x;
            int num = 0;
            while(x!=0){
                num = num*10+x%10;
                x /= 10;
            }
            if(num==k)
                return true;
            else
                return false;
        }
    }
}
