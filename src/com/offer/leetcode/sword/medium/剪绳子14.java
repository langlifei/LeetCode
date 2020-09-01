package com.offer.leetcode.sword.medium;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/7 17:13
 * @Describe key:使用贪心策略
 *              1.先选3，因为3拆分后比3小
 *              2.次选2, 同理
 *              3.最后余1时，因选4.因为4>1*3
 */

public class 剪绳子14 {

    public int cuttingRope(int n) {
        if(n==2)
            return 1;
        int m = n/3;
        int p = n%3;
        if(p==1)
            return (int) (Math.pow(3,m-1)*4);
        else if(p==2)
            return (int) (Math.pow(3,m)*2);
        return (int) Math.pow(3,m);
    }


}
