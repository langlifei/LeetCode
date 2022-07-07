package com.offer.leetcode.medium;

class Leetcode_334 {

    public boolean increasingTriplet(int[] nums) {
        int[][] matrix = new int[5][4];
        if(nums.length <= 2){
            return false;
        }
        //-2是因为只会判断到nums.length-2这个下标
        int[] leftMin = new int[nums.length-1];
        int[] rightMax = new int[nums.length];
        //寻找每个数的左边最小值
        int temp = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length - 1; i++){
            if(nums[i-1] < temp){
                temp = nums[i - 1];
            }
            leftMin[i] = temp;
        }
        //寻找每个数的右边最大值
        temp = Integer.MIN_VALUE;
        for(int i = nums.length - 2; i > 0 ; i--){
            if(nums[i + 1] > temp){
                temp = nums[i+1];
            }
            rightMax[i] = temp;
        }
        //寻找是否存在递增的三元子序列.
        for(int i = 1; i < nums.length - 1; i++){
            if(nums[i] > leftMin[i] && nums[i] < rightMax[i]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Leetcode_334().increasingTriplet(new int[]{0,4,2,1,0,-1,-3});
    }
}
