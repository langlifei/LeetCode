package com.offer.leetcode.sword.medium;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/7 11:39
 * @Describe key：使用深度优先搜索
 *                1.控制访问过的不许重新访问
 *                2.上下左右四个方向都要搜
 *                3.使用下标来判断是否搜到目标字符串的最后一个字符
 */

public class 矩阵中的路径12 {

    public boolean exist(char[][] board, String word) {
        for(int i = 0 ; i < board.length;i++)
            for(int j = 0 ; j < board[0].length;j++)
               if(dfs(board,word,i,j,0))
                   return true;
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        if(i<0 || i > board.length || j < 0 || j > board[0].length || board[i][j]!=word.charAt(k))
            return false;
        if(k==word.length()-1)//如果存在访问路径，则返回true
            return true;
        char temp = board[i][j];
        board[i][j] = '/';//表示已经访问过
        boolean res = dfs(board,word,i+1,j,k+1) || dfs(board,word,i-1,j,k+1) ||
                dfs(board,word,i,j-1,k+1) || dfs(board,word,i,j+1,k+1);//进行上下左右深搜
        board[i][j] = temp;//将值还原
        return res;
    }
}
