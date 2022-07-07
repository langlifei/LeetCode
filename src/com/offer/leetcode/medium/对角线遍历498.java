package com.offer.leetcode.medium;

/**
 * @Description:
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * @Example:
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 * @Author: zz
 * @Date: 2022/6/14 14:19
 */
class Solution498 {

    /**
     * 直接模拟其遍历思想
     * @param mat
     * @return
     */
    public int[] findDiagonalOrder(int[][] mat) {
        //verse * flag = 1表示向上，verse * flag = -1表示向下
        int verse = -1;
        int flag = -1;
        int row = mat.length;;
        int col = mat[0].length;
        int[] res = new int[mat.length * mat[0].length];
        int index = 0;
        int currentRow = 0;
        int currentCol = 0;
        int c = 1, r = -1;
        while(index < res.length){
            res[index++] = mat[currentRow][currentCol];
            verse = verse * flag;
            while(true){
                if(currentRow + (verse * r) >= 0 && currentRow + (verse * r) < row){
                    currentRow = currentRow + (verse * r);
                }else{
                    break;
                }
                if(currentCol + (verse * c) >= 0 && currentCol + (verse * c) < col){
                    currentCol = currentCol + (verse * c);
                }else{
                    currentRow -= (verse * r);
                    break;
                }
                res[index++] = mat[currentRow][currentCol];
            }
            if(verse == 1){
                if(currentCol + 1 < col){
                    currentCol++;
                }else{
                    currentRow++;
                }
            }else{
                if(currentRow + 1 < row){
                    currentRow++;
                }else{
                    currentCol++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution498().findDiagonalOrder(new int[][]{{1,2,3,4}});
    }
}
