package com.offer.leetcode.easy;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/16 10:20
 * @Describe
 */

class Easy02 {

    private static final int UP = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;
    private static final int RIGHT = 4;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null||image[0]==null||image[0].length<=0)
            return image;
        if(image[sr][sc]==newColor)
            return image;
        int dir = 0;//方向,0表示第一次进来,1表示上,2表示下,3标准左,4表示右
        updateSRC(image,sr,sc,newColor,dir);
        return image;
    }

    public void updateSRC(int[][] image, int sr, int sc, int newColor,int dir){
        if(sr < 0 || sc < 0 || sr > image.length - 1 || sc > image[0].length - 1)
            return;
        //修改当前值
        int temp = image[sr][sc];
        image[sr][sc]  = newColor;
        //向上修改
        if(sr-1>=0 && image[sr-1][sc] == temp && dir!=Easy02.DOWN)
            updateSRC(image,sr-1,sc,newColor,Easy02.UP);
        //向下修改
        if(sr+1 < image.length && image[sr+1][sc] == temp && dir != Easy02.UP)
            updateSRC(image,sr+1,sc,newColor,Easy02.DOWN);
        //向左修改
        if(sc-1>=0 && image[sr][sc-1] == temp && dir != Easy02.RIGHT)
            updateSRC(image,sr,sc-1,newColor,Easy02.LEFT);
        //向右修改
        if(sc+1 < image[0].length && image[sr][sc+1] == temp && dir != Easy02.LEFT)
            updateSRC(image,sr,sc+1,newColor,Easy02.RIGHT);
    }

    public static void main(String[] args) {
        int[][] image = new int[][]{{0,0,0},{0,1,1}};
        Easy02 test = new Easy02();
        System.out.println(test.floodFill(image, 1, 1, 1));
    }
}
