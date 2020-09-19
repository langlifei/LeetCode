package com.offer.codingInterviewGuide.arrayAndMatrix;

class Array12 {

    public int[][] generateMatrix(int n) {
        if( n < 0 )
            return null;
        else if( n == 0)
            return new int[n][n];
        int[][] array  = new int[n][n];
        int scope = 0;
        int temp = 1;
        int i = 0 ;
        int j = 0;
        while(temp<=n*n){
            //向左走
            while(temp <= n*n && j < n-scope )
                array[i][j++] = temp++;
            j--;//回退一格
            i++;
            //向下走
            while(temp <= n*n && i < n-scope )
                array[i++][j] = temp++;
            i--;
            j--;
            //向右走
            while(temp <= n*n && j >= scope )
                array[i][j--] = temp++;
            j++;
            i--;
            scope++;
            //向上走
            while(temp <= n*n && i >= scope )
                array[i--][j] = temp++;
            i++;
            j++;
        }
        return array;
    }

    public static void main(String[] args) {
        Array12 test12 = new Array12();
        test12.generateMatrix(3);
    }
}
