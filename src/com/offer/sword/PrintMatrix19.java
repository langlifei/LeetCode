package com.offer.sword;
import java.util.ArrayList;
/*
                                时间:2020年3月9日11:46:04
                                地点:湖北省仙桃市
                                问题:输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
                                     例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
                                     则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
                                结果:通过
                                注:1.遍历的方向
                                   2.回退一次
                                   3.记录圈数
                                   4.记录总个数

 */
public class PrintMatrix19 {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int i = 0 , j = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int count= 0;
        int max = n*matrix[0].length;
        int t = 0; //表示转动的圈数.
        ArrayList<Integer> list = new ArrayList<>();
        while(count<max){
            //向右走
            while(j<m-t&&count++<max)
                list.add(matrix[i][j++]);
            //往回退一步
            j--;
            //向下走
            while(++i<n-t&&count++<max)
                list.add(matrix[i][j]);
            i--;
            //向左走
            while(--j>=t&&count++<max)
                list.add(matrix[i][j]);
            j++;
            t++;//表示走了大半圈
            //向上走
            while(--i>=t&&count++<max)
                list.add(matrix[i][j]);
            i++;
            j++;
        }
        return list;
    }

    public static void main(String[] args){
        PrintMatrix19 p = new PrintMatrix19();
        int[][] matrix = new int[][]{{1},{2},{3},{4},{5}};
        p.printMatrix(matrix);
    }
}
