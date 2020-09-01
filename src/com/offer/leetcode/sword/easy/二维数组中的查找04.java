package com.offer.leetcode.sword.easy;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/6 17:16
 * @Describe 以右上角为起点寻找，缩小寻找的范围矩阵
 */

public class 二维数组中的查找04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0)
            return false;
        int i = 0;
        int j = matrix[0].length-1;
        while(i<matrix.length&&j>=0){
            if(matrix[i][j]>target)
                j--;
            else if(matrix[i][j]<target)
                i++;
            else
                return true;
        }
        return false;
    }
}
