package com.offer.codingInterviewGuide.recurrenceAndDP;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/15 20:39
 * @Describe
 */

class DP06 {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length<=0)
            return false;
        if(nums.length==1)
            return true;
        boolean[] flags = new boolean[nums.length];
        flags[0]=true;
        boolean flag = false;
        for(int i = 1 ; i < nums.length;i++){
            for(int j = i - 1; j >= 0 ; j--){
                flag |= (flags[j]&&nums[j]>=i-j);
                if(flag){
                    flags[i] = true;
                    break;
                }
            }
            flag = false;
        }
        return flags[nums.length-1];
    }

    public static void main(String[] args) {
        DP06 test = new DP06();
        System.out.println(test.canJump(new int[]{3,2,1,0,4}));
    }
}
