package com.offer.codingInterviewGuide.recurrenceAndDP;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/8 16:28
 * @Describe
 */

class DP03 {


    public int minPathSum1(int[][] m){
        if(m==null || m.length == 0 || m[0] == null || m[0].length == 0)
            return 0;
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        //生成左上角结点
        dp[0][0] = m[0][0];
        //生成dp第一列
        for(int i = 1 ; i < row ; i++)
            dp[i][0] = m[i-1][0]+m[i][0];
        //生成dp第一行
        for(int j = 1; j < col ; j++)
            dp[0][j] = m[0][j-1]+m[0][j];
        //生成dp矩阵其它结点
        for(int i = 1 ; i < row ; i++)
            for(int j = 1 ; j < col ; j++)
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+m[i][j];
        return dp[row-1][col-1];
    }

    public int minPathSum2(int[][] m){
        if(m==null || m.length == 0 || m[0] == null || m[0].length==0)
            return 0;
        int more = Math.max(m.length,m[0].length);
        int less = Math.min(m.length,m[0].length);
        boolean rowMore = more == m.length;//是否行数大于等于列数,决定dp数组滚动方向是从上往下还是从左往右
        int[] dp = new int[less];
        dp[0] = m[0][0];//生成第一个结点
        //初始化dp,由rowMore来决定初始化的dp是第一行,还是第一列 rowMore == true 为第一行,否则为第一列
        for(int i = 1; i < less; i++)
            dp[i] = dp[i-1]+(rowMore ? m[0][i] : m[i][0]);
        for(int i = 1; i < more; i++){
            //更新dp的第一个结点,因为dp数组的结点在更新时依赖前一个结点
            dp[0] = dp[0]+(rowMore ? m[i][0] : m[0][i]);
            //如果向下滚动,那么dp[j-1]的值为当前节点的左边的值,dp[j]为当前节点的上边的值
            //如果向右滚动,那么dp[j-1]的值为当前节点的上边的值,dp[j]为当前节点的左边的值
            for( int j = 1 ; j < less; j++)
                dp[j] = Math.min(dp[j-1],dp[j])+(rowMore ? m[i][j] : m[j][i]);
        }
        return dp[less-1];
    }

    public static void main(String[] args) {
        DP03 test = new DP03();
        int[][] m = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        System.out.println("矩阵最短路径和为:"+test.minPathSum1(m));
        System.out.println("矩阵最短路径和为:"+test.minPathSum2(m));
    }
}
