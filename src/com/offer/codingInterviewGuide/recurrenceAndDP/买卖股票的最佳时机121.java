package com.offer.codingInterviewGuide.recurrenceAndDP;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/16 17:57
 * @Describe
 */

class DP07 {

    public int maxProfit(int[] prices) {
        if(prices==null || prices.length <= 0)
            return 0;
        int[] dp = new int[prices.length];
        //初始化dp数组
        int temp = Integer.MIN_VALUE;
        for(int i = 1; i < prices.length;i++)
            dp[i] = Math.max(dp[i-1],prices[i]-prices[0]);
        for(int i = 1 ; i < prices.length;i++){
            temp = Integer.MIN_VALUE;
            for(int j = i+1 ; j < prices.length; j++){
                temp = Math.max(dp[j],temp);
                temp = Math.max(temp,prices[j]-prices[i]);
                dp[j] = temp;
            }
        }
        return dp[prices.length-1];
    }

    public int maxProfit1(int[] prices) {
        if(prices==null || prices.length <= 0)
            return 0;
        int[] dp = new int[prices.length];
        //初始化dp数组
        for(int i = 1; i < prices.length;i++)
            dp[i] = Math.max(dp[i-1],prices[i]-prices[0]);
        for(int i = 1 ; i < prices.length;i++)
            for(int j = i+1 ; j < prices.length; j++)
                dp[j] = Math.max(dp[j],Math.max(dp[j-1],prices[j]-prices[i]));
        return dp[prices.length-1];
    }

    public static void main(String[] args) {
        DP07 test = new DP07();
        System.out.println(test.maxProfit1(new int[]{7,1,5,3,6,4}));
    }
}
