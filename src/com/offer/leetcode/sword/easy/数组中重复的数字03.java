package com.offer.leetcode.sword.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/6 16:53
 * @Describe
 */

public class 数组中重复的数字03 {

    public int findRepeatNumber(int[] nums) {
        int[] array = new int[nums.length];
        for(int i = 0 ; i < nums.length;i++){
            if(array[nums[i]]==0)
                array[nums[i]]=1;
            else
                return nums[i];
        }
        return -1;
    }

}
