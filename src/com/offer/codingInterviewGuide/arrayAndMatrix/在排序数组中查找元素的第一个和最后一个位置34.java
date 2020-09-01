package com.offer.codingInterviewGuide.arrayAndMatrix;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/20 21:46
 * @Describe
 */

class Array02 {

    public int[] searchRange(int[] nums, int target) {
        int[] temp = new int[]{-1,-1};
        if(nums==null || nums.length<=0)
            return temp;
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        while(start <= end){
            mid = (start + end) / 2;
            if(nums[mid]<target)
                start = mid + 1;
            else if(nums[mid]>target)
                end = mid - 1;
            else{
                int left = mid;
                int right = mid;
                while(left-1>=0 && nums[left-1]==target)
                    left--;
                while(right+1<nums.length && nums[right+1]==target)
                    right++;
                temp[0] = left;
                temp[1] = right;
                break;
            }
        }
        return temp;
    }
}
