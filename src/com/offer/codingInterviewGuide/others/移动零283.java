package com.offer.codingInterviewGuide.others;


/**
 * @Author Zeng Zhuo
 * @Date 2020/8/19 19:29
 * @Describe
 */

class Other02 {
    public void moveZeroes(int[] nums) {
        if(nums==null || nums.length<= 0)
            return;
        int count = 0;
        for(int i = 0 ; i < nums.length-count ; i++){
            if( nums[i] == 0 ){
                count++;
                for(int j = i ; j < nums.length-count;j++)
                    nums[j] = nums[j+1];
                nums[nums.length-count]=0;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        Other02 test = new Other02();
        int[] nums = new int[]{0,1,0,3,12};
        test.moveZeroes(nums);
    }
}
