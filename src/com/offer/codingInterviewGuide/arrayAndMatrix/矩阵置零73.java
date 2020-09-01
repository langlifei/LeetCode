package com.offer.codingInterviewGuide.arrayAndMatrix;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/31 20:39
 * @Describe
 */

class Array09 {


    private Set<Integer> colSet = new HashSet();
    private Set<Integer> rowSet = new HashSet();

    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length <= 0 || matrix[0] == null || matrix[0].length <= 0)
            return ;
        boolean updateRow;
        for(int i = 0 ; i < matrix.length; i++){
            updateRow = false;
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == 0 && !colSet.contains(j)){
                    updateColumn(matrix,j);
                    colSet.add(j);
                    updateRow = true;
                }
            }
            if(updateRow || rowSet.contains(i))
                updateRow(matrix,i);
        }
    }

    private void updateRow(int[][] matrix, int row) {
        for( int j = 0 ; j < matrix[0].length ; j++ )
            matrix[row][j] = 0;
    }

    private void updateColumn(int[][] matrix, int j) {
        for(int i = 0; i < matrix.length ; i++){
            if(matrix[i][j] == 0)
                rowSet.add(i);
            else
                matrix[i][j] = 0;
        }
    }
}
