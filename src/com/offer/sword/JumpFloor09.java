package com.offer.sword;

/*
*                               时间:2020年3月6日15:03:27
*                               地点:湖北省仙桃市
*                               问题:一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
*                                    求该青蛙跳上一个n级的台阶总共有多少种跳法。
*                               结果:通过观察其规律可发现n = 2f(n-2)+f(n-1)
*                               通过率:100%
 *
* */

public class JumpFloor09 {

    public int JumpFloorII(int target) {
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
