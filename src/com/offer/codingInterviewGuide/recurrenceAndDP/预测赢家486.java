package com.offer.codingInterviewGuide.recurrenceAndDP;

/**
 * @Author Zeng Zhuo
 * @Date 2020/9/1 14:04
 * @Describe
 */

class 预测赢家486 {

    public boolean PredictTheWinner(int[] nums) {
        if(nums == null || nums.length <= 0)
            return true;
        int[] dp = new int[nums.length];
        for(int i = 0 ; i < nums.length; i++)
            dp[i] = nums[i];
        for(int i= nums.length - 2 ; i >= 0 ; i--)
            for(int j = i+1 ; j < nums.length; j++)
                dp[j] = Math.max(nums[i] - dp[j] , nums[j] - dp[j-1]);
        return dp[nums.length-1]>=0;
    }

}
