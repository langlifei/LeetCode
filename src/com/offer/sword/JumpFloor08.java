package com.offer.sword;

/*
*                       时间:2020年3月6日11:52:33
*                       地点:湖北省仙桃市
*                       问题:一只青蛙一次可以跳上1级台阶，也可以跳上2级。
*                           求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果)
*                       通过率:100%
*                       思路:对不同的台阶进行分析,可发现其规律和斐波拉契数列的规律一样.
* */

public class JumpFloor08 {

    public int JumpFloor(int target) {
        if(target == 0){
            return 0;
        }else if(target == 1)
            return 1;
        else if(target ==2)
            return 2;
        int i = 1 , j = 2;
        int temp = 0;//初始化
        while(target > 2){
            temp = 2*i+j;
            i = j;
            j = temp;
            target--;
        }
        return temp;
    }
}
