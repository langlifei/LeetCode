package com.offer.codingInterviewGuide.others;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/20 9:20
 * @Describe
 */

class Other04 {

    //当方向太多时,使用数字来控制方向,否则写起来过于繁琐
    private int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    private int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};
    private int DIR = 8;

    public char[][] updateBoard(char[][] board, int[] click) {
        if(board==null || board.length<=0 || board[0]==null || board[0].length <= 0 || click==null || click.length<2
                || click[0]<0 || click[0] >= board.length || click[1] < 0 || click[1] >= board[0].length)
            return board;
        int row = click[0];
        int col = click[1];
        char op = board[row][col];
        if(op != 'M' && op != 'E')
            return board;
        if(op == 'M'){
            board[row][col] = 'X';
            return board;
        }else
            return dfs(board,row,col);
    }

    private char[][] dfs(char[][] board, int row, int col) {
        //查找地雷
        int count = 0;
        int trow = 0;
        int tcol = 0;
        for(int i = 0 ; i < DIR ; i++){
            trow = row + dirX[i];
            tcol = col + dirY[i];
            if(trow < 0 || trow >= board.length || tcol<0 || tcol >= board[0].length)
                continue;
            if(board[trow][tcol] == 'M')
                count++;
        }
        if(count>0) // 如果周围有雷,则只修改雷数,不去dfs
            board[row][col] = (char)(count+'0');
        else{
            board[row][col] = 'B';
            for(int i = 0 ; i < DIR; i++){
                trow = row + dirX[i];
                tcol = col + dirY[i];
                if(trow < 0 || trow >= board.length || tcol<0 || tcol >= board[0].length || board[trow][tcol]!='E')
                    continue;
                dfs(board,trow,tcol);
            }
        }
        return board;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                                        {'E','E','E','E','E'},
                                        {'E','E','M','E','E'},
                                        {'E','E','E','E','E'},
                                        {'E','E','E','E','E'}
                                        };
        Other04 test = new Other04();
        int[] click = new int[]{3,0};
        System.out.println(test.updateBoard(board,click));
        Queue queue = new LinkedList();
        queue.poll();
    }
}
