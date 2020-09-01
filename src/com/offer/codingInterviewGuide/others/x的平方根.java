package com.offer.codingInterviewGuide.others;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/23 10:07
 * @Describe
 */

class Other05 {
    public int mySqrt(int x) {
        if(x <= 0)
            return 0;
        int start = 1;
        int end = x/2+1;
        while( start <= end ){
            if(x >= start*start && x < (start+1)*(start+1))
                return start;
            if( x < end*end && x >= (end-1)*(end-1))
                return end-1;
            end--;
            start++;
        }
        return start;
    }

    public static void main(String[] args) {
        Other05 test = new Other05();
        System.out.println(test.mySqrt(5));
    }
}
