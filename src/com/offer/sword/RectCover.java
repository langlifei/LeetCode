package com.offer.sword;


/*
*                       时间:2020年3月6日15:33:38
*                       地点:湖北省仙桃市
*                       问题:我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
*                            请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
*                       结果:斐波拉契数列
*
* */
public class RectCover {

    public int RectCover(int target) {
        if(target == 0){
            return 0;
        }else if(target == 1)
            return 1;
        else if(target ==2)
            return 2;
        int i = 1 , j = 2;
        int temp = 0;//初始化
        while(target > 2){
            temp = i+j;
            i = j;
            j = temp;
            target--;
        }
        return temp;
    }
}
