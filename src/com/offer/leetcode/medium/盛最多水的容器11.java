package com.offer.leetcode.medium;

/**
 *                      时间:2020年4月13日18:07:30
 *                      题解:1.使用双指针从两边向中间移动
 *                      问题:只使用了单向指针.
 */
public class 盛最多水的容器11 {

    public static int maxArea(int[] height){
        int l = 1;//左边的下标
        int lh = height[l-1];//左边的高度
        int r = height.length-1;
        int rh = height[r];
        int area = 0;
        int maxArea = 0;
        while(l<=r){
            area = (r+1-l)*Math.min(lh,rh);
            if(area>maxArea){
                maxArea = area;
            }
            if (lh<rh)
                lh = height[l++];
            else
                rh = height[--r];
        }
        return maxArea;
    }

    public static void main(String... args){
        System.out.println(maxArea(new int[]{2,3,4,5,18,17,6}));
    }
}
