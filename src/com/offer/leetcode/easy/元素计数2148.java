package com.offer.leetcode.easy;

import java.util.Arrays;

/**
 * @Author: zz
 * @Date: 2022/6/24 16:59
 */
class Solution2148 {

    public int countElements(int[] nums) {
        int len = nums.length;
        if(len < 3){
            return 0;
        }
        Arrays.sort(nums);
        //计算最小值的个数
        int minNum = 0;
        int result = nums.length - count(nums,nums[0],1) - count(nums,nums[len-1],-1);
        return Math.max(result, 0);
    }

    public int count(int[] num , int value, int type){
        int position = 0;
        int result = 0;
        if(type == 1){
            position = 0;
        }else if(type == -1){
            position = num.length-1;
        }
        while( position >= 0 && position < num.length){
            if(num[position] == value){
                result++;
            }
            position += type;
        }
        return result;
    }
}
