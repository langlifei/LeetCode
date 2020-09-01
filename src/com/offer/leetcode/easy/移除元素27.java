package com.offer.leetcode.easy;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/4 23:10
 * @Describe
 */

public class 移除元素27 {

    public int removeElement(int[] nums, int val) {
        int dn = 0;
        int index = 0;
        for(int i = 0 ; i < nums.length;i++){
            while(i<nums.length&&nums[i]==val){
                i++;
                dn++;
            }
            if(i<nums.length)
                nums[index++] = nums[i];
        }
        return nums.length-dn;
    }
}
