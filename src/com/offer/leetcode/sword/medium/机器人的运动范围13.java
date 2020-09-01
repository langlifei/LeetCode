package com.offer.leetcode.sword.medium;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/7 12:10
 * @Describe
 */

public class 机器人的运动范围13 {

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(visited,m,n,0,0,k);
    }

    public int dfs(boolean[][] visited,int m, int n, int i, int j, int k){
        //控制边界
        if(i<0 || i > m-1 || j < 0 || j > n-1)
            return 0;
        //条件判断
        int temp = 0;
        temp = rowAndColSum(i)+rowAndColSum(j);
        if(temp>k)
            return 0;
        if(visited[i][j])
            return 0;
        visited[i][j] = true;
        return dfs(visited,m,n,i+1,j,k)+dfs(visited,m,n,i-1,j,k)+dfs(visited,m,n,i,j-1,k)+dfs(visited,m,n,i,j+1,k)+1;
    }

    public int rowAndColSum(int i){
        int sum = 0;
        while(i>0){
            sum+= i % 10;
            i/=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        机器人的运动范围13 test = new 机器人的运动范围13();
        System.out.println(test.movingCount(2, 3, 1));
    }
}
