package com.offer.codingInterviewGuide.recurrenceAndDP;

import java.util.*;

/**
 * @Author Zeng Zhuo
 * @Date 2020/9/3 8:11
 * @Describe 1.使用回溯进行枚举出所有的解法
 *           2.回溯时查看是否满足N皇后的规则,不满足直接返回进行下一次枚举
 */

class DP15 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        if( n <= 0)
            return lists;
        int[] queue = new int[n];//存储每个皇后在不同行中的列下标,即记录皇后所在的位置
        Arrays.fill(queue,-1);
        Set<Integer> columns = new HashSet<>(); //存储已经被占据的列
        Set<Integer> diagonals1 = new HashSet<>(); //存储已经被占据的主对角线,每个主对角线的行和列之差相等
        Set<Integer> diagonals2 = new HashSet<>(); //存储已经被占据的副对角线,每个副对角线的行和列之和相等
        backtrack(queue,n,0,columns,diagonals1,diagonals2,lists);
        return lists;
    }

    private void backtrack(int[] queue, int n, int row,Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2,List<List<String>> lists) {
        //当枚举到第N个元素时,说明当前queue中存储着一种N皇后的解法,故需将其存储在解集中.
        if( row == n ){
            List<String> s = generateBoard(queue);
            lists.add(s);
            return;
        }
        int d1 = -1;
        int d2 = -1;
        for(int i = 0 ; i < n ; i++){
            //检查主对角线
            d1 = row - i;
            d2 = row + i;
            //在同一行直接跳出
            if( columns.contains(i) )
                continue;
            //在同一主对角上直接跳出
            if(diagonals1.contains(d1))
                continue;
            //在同一副对角上直接跳出
            if(diagonals2.contains(d2))
                continue;
            //满足条件添加当前位置
            queue[row] = i; // 添加当前位置
            columns.add(i);
            diagonals1.add(d1); //添加主对角线
            diagonals2.add(d2); //添加副对角线
            //以当前行为基础查看下一个行是否也满足条件
            backtrack(queue,n,row+1,columns,diagonals1,diagonals2,lists);
            //进行回退
            queue[row] = -1;
            columns.remove(i);
            diagonals1.remove(d1);
            diagonals2.remove(d2);
        }
    }

    private List<String> generateBoard(int[] queue) {
        char[] temp = null;
        List<String> board = new ArrayList<>();
        for(int i = 0 ; i < queue.length ; i++){
            temp = new char[queue.length];
            Arrays.fill(temp,'.');
            temp[queue[i]] = 'Q';
            board.add(String.valueOf(temp));
        }
        return board;
    }

}
