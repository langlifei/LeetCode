package com.offer.leetcode.sword.easy;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/13 10:10
 * @Describe 借助快速排序的思想
 */

public class 调整数组顺序使奇数位于偶数前面21 {
    public int[] exchange(int[] nums) {
        if(nums.length==0)
            return nums;
        int start = 0;
        int end = nums.length-1;
        //从右边找到第一个奇数
        while(end>=0&&nums[end]%2==0)
            end--;
        if(end<0)
            return nums;
        int p = nums[end];
        while(start<end){
            //从左边找到偶数
            while(start<end&&nums[start]%2!=0)
                start++;
            nums[end] = nums[start];
            while(start<end&&nums[end]%2==0)
                end--;
            nums[start] = nums[end];
        }
        nums[start] = p;
        return nums;
    }
}
