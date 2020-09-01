package com.offer.codingInterviewGuide.recurrenceAndDP;

/**
 * @Author Zeng Zhuo
 * @Date 2020/7/28 19:29
 * @Describe
 */

class DP01 {

    public int minSteps(int n) {
        int[] dp = new int[n+1];
        for(int i = 2; i < dp.length; i++){
            dp[i] = i;//如果当前数是质数,那么其值不会被更改
            for(int j = 2 ; j <= Math.sqrt(n);j++){
                if( i % j == 0){
                    /**
                     * 两个因素相加  注:两个越靠近的数其和越小 i >= j ,dp[i]是前面两个状态dp[j]+dp[i/j]
                     * 由于dp[j]和dp[i/j]都是最优,所以dp[i]是最优,dp[j]和dp[i/j]的最优由初试条件递推出来.
                     */
                    dp[i] = dp[j] + dp[i/j];
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        DP01 test = new DP01();
        System.out.println(test.minSteps(30));
    }
}
