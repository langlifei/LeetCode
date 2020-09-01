package com.offer.codingInterviewGuide.recurrenceAndDP;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/18 20:21
 * @Describe
 */

class DP09 {

    public int maxValue(int[][] grid) {
        if( grid == null || grid.length <= 0 || grid[0] == null || grid[0].length <= 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int min = Math.min(m,n);
        int max = Math.max(m,n);
        boolean flag  = m == max ? true : false;
        int[] dp = new int[min];
        dp[0] = grid[0][0];
        for(int i = 1 ; i < dp.length;i++)
            dp[i] = dp[i-1]+(flag?grid[0][i]:grid[i][0]);
        for(int i = 1 ; i < max; i++){
            dp[0] = dp[0]+(flag?grid[i][0]:grid[0][i]);
            for(int j = 1; j < dp.length; j++)
                dp[j] = Math.max(dp[j],dp[j-1]) + (flag?grid[i][j]:grid[j][i]);
        }
        return dp[min-1];
    }
}
