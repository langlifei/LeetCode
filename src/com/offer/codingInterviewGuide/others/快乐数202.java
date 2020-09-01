package com.offer.codingInterviewGuide.others;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/25 17:30
 * @Describe
 */

class Other06 {

    public boolean isHappy(int n) {
        // 如果n不是快乐数，那么一定会有一个隐式的环，故可通过快慢指针法来检查环路,注意快慢指针的初始化
        if( n <= 0 )
            return false;
        if( n == 1 )
            return true;
        int fast = getNext(n);
        int slow = n;
        while(fast != 1 && fast != slow){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1 ? true : false;
    }

    private int getNext(int n){
        int temp = 0;
        int m = 0;
        while(n > 0){
            m = n % 10;
            temp += m * m;
            n /= 10;
        }
        return temp;
    }
}
