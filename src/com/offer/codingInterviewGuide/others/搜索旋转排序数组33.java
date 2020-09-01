package com.offer.codingInterviewGuide.others;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/19 23:18
 * @Describe
 */

class Other03 {

    public int search(int[] nums, int target) {
        if(nums==null || nums.length<=0)
            return -1;
        int start = 0;
        int end = nums.length-1;
        int mid ;
        while(start<=end){
            mid = (start+end)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[0]<=nums[mid]){//判断左边是否有序
                if(nums[0]<=target && target < nums[mid]) //查看target是否在其区间内
                    end = mid -1;
                else
                    start = mid + 1;
            }else{//如果无序
                if(nums[mid]<target && target < nums[nums.length-1]) //是否在右边有序区间内
                    start = mid + 1;
                else  //如果不在,则缩小左边无序数组的区间
                    end = mid -1;
            }

        }
        return -1;
    }
}
