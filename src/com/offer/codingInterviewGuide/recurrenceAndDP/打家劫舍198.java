package com.offer.codingInterviewGuide.recurrenceAndDP;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/16 18:42
 * @Describe
 */

class DP08 {

    public int rob(int[] nums) {
        if(nums==null || nums.length<=0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int[] dp = new int[]{nums[0],nums[1]};
        for(int i = 2 ; i < nums.length;i++){
            dp[i%2] = nums[i]+Math.max(dp[i%2],dp[(i-1)%2]-nums[i-1]);
        }
        return dp[0]>=dp[1]?dp[0]:dp[1];
    }

    public static void main(String[] args) {
        DP08 test = new DP08();
        System.out.println(test.rob(new int[]{2,1,1,2}));
    }
}
