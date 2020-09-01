package com.offer.leetcode.easy;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/3 15:42
 * @Describe
 */

public class 删除排序数组中的重复项26 {

    public int removeDuplicates(int[] nums) {
        int dn = 0;
        int index = 0;
        for(int i = 0 ; i < nums.length;i++){
            while(i>0&&i<nums.length&&nums[i]==nums[i-1]){
                i++;
                dn++;
            }
            if(i<nums.length)
                nums[index++] = nums[i];
        }
        return nums.length-dn;
    }
}
