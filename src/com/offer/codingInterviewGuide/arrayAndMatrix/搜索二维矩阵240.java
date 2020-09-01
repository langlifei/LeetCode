package com.offer.codingInterviewGuide.arrayAndMatrix;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/27 14:04
 * @Describe
 */

class Array07 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if( matrix == null || matrix.length <= 0 || matrix[0] == null || matrix[0].length <= 0 )
            return false;
        int i = 0 ;
        int j = matrix[0].length-1;
        while(j >= 0 && i < matrix.length){
            if(matrix[i][j] > target )
                j--;
            else if(matrix[i][j] < target)
                i++;
            else
                return false;
        }
        return false;
    }
}
