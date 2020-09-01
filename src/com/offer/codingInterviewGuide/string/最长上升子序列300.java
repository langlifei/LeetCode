package com.offer.codingInterviewGuide.string;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/23 20:06
 * @Describe
 */

class String03 {

    //思维不能固化，不一定都是以某个数开头，也可以以某个数结尾
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length<=0)
            return 0;
        else if(nums.length==1)
            return 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        //初始化
        int max = 1;
        int temp = 0;
        for(int i = 1 ; i < dp.length; i++){
            temp = 0;
            for(int j = 0 ; j < i;j++){
                if(nums[j] < nums[i] && temp <= dp[j])
                    temp = dp[j];
            }
            dp[i] = temp + 1;
            if(max < dp[i])
                max = dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        String03 test = new String03();
        int[] data  = new int[]{1,3,6,7,9,4,10,5,6};
        System.out.println(test.lengthOfLIS(data));
    }
}
