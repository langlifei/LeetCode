package com.offer.codingInterviewGuide.recurrenceAndDP;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/20 15:03
 * @Describe
 */

class DP10 {

    private int[] dirRow = new int[]{1,-1,0,0};
    private int[] dirCol = new int[]{0,0,-1,1};

    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length<=0 || grid[0] == null || grid[0].length <= 0)
            return -1;
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();
        //将最初腐烂的橘子添加到队列,并把其对应的腐烂时间存入map中,0表示最初就是腐烂的.
        int R = grid.length;
        int C = grid[0].length;
        for(int i = 0 ; i < R ; i++)
            for(int j = 0 ; j < C ; j++)
                if( grid[i][j] == 2){
                    queue.add(i*C+j);
                    map.put(i*C+j,0);
                }
        int res = 0;
        int temp ;
        int row , col;
        int tRow , tCol;
        int code = 0;
        //开始广度优先遍历
        while(!queue.isEmpty()){
            temp = queue.poll();
            row = temp / C ;
            col = temp % C ;
            for(int i = 0; i < 4 ; i++){
                tRow = row+dirRow[i];
                tCol = col+dirCol[i];
                if(tRow<0 || tRow >= R || tCol < 0 || tCol >= C || grid[tRow][tCol]==0 || grid[tRow][tCol]==2)
                    continue;
                //将新鲜橘子改变为腐烂橘子
                grid[tRow][tCol] = 2;
                //将当前腐烂橘子记录在队列中
                code = tRow*R+tCol;
                queue.add(code);
                //设置当前橘子腐烂的时间,即为它周围的橘子腐烂的时间加1
                map.put(code,map.get(temp)+1);
                //由于是广度优先遍历,所以队列中的最后一个橘子的腐烂时间为所有橘子腐烂的时间
                res = map.get(code);
            }
        }
        //查看是否还存在新鲜橘子
        for(int i = 0 ; i < R ; i++)
            for(int j = 0 ; j < C ; j++)
                if(grid[i][j]==1)
                    return -1;
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1},{2},{1},{1}};
        DP10 test = new DP10();
        System.out.println(test.orangesRotting(grid));
    }
}
