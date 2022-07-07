package com.offer.leetcode.medium;

import java.util.Arrays;

class Leetcode_475 {
    public int findRadius(int[] houses, int[] heaters) {
        //对houses和heaters进行排序
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        int j = 0;
        //关键信息:依赖关系, 前一个房子找到的最近供暖期一定是当前房子能从左边到当前位置的最近供暖器
        for(int i = 0 ; i < houses.length ; i++){
            //计算起始的最小距离
            int curDistance = Math.abs(houses[i]-heaters[j]);
            //当前供暖期比下一个供暖器远的时候, 将j向右移,找到最近的供暖器位置.
            while(j < heaters.length - 1 && Math.abs(houses[i]-heaters[j]) >= Math.abs(houses[i]-heaters[j+1])){
                j++;
                curDistance = Math.abs(houses[i]-heaters[j]);
            }
            //通过找到每个房子供暖器最近的距离,从中找到最大的距离,从而找到所有房子供暖器最大的半径.
            ans = Math.max(ans,curDistance);
        }
        return ans;
    }
}
