package com.offer.codingInterviewGuide.recurrenceAndDP;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/22 21:30
 * @Describe
 */

class DP13 {


    private int[] dirRow = new int[]{1,0,-1,0};
    private int[] dirCol = new int[]{0,-1,0,1};
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length<=0||grid[0]==null||grid[0].length<=0)
            return 0;
        int count = 0;
        for(int i = 0 ; i < grid.length ; i++)
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j,-1);
                    count++;
                }
            }
        return count;
    }

    private void dfs(char[][] grid, int row, int col,int dir) {
        int tempRow = 0;
        int tempCol = 0;
        for(int i = 0 ; i < dirCol.length; i++){
            tempRow = row+dirRow[i];
            tempCol = col+dirCol[i];
            if( i == dir || tempRow < 0 || tempRow>= grid.length || tempCol < 0 || tempCol >= grid[0].length || grid[tempRow][tempCol]=='0')
                continue;
            grid[tempRow][tempCol] = '0';
            dfs(grid,tempRow,tempCol,(i+2)%4);
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                    {'1','1','1','1','0'},
                    {'1','1','0','1','0'},
                    {'1','1','0','0','0'},
                    {'0','0','0','0','0'}};
        DP13 test = new DP13();
        System.out.println(test.numIslands(grid));
    }
}
