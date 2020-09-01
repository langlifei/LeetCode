package com.offer.codingInterviewGuide.recurrenceAndDP;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/22 11:56
 * @Describe
 */

class DP12 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m ; i++)
            for(int j = 0 ; j < n; j++)
                if((i == 0 && j == 0)||(i-1<0)||(j-1<0))
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        DP12 test = new DP12();
        System.out.println(test.uniquePaths(19, 13));
    }
}
