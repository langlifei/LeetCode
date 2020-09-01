package com.offer.codingInterviewGuide.recurrenceAndDP;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/8 10:01
 * @Describe
 */

class DP02 {

    //时间复杂度为o(2^n)
    public int f1(int n){
        if( n < 1)
            return 0;
        if( n == 1 || n ==2) // n == 2 的时候可以直接返回1 ,所以加一个 n == 2 的条件,避免再计算一次
            return 1;
        else
            return f1(n-1)+f1(n-2);
    }

    //时间复杂度o(n)
    public int f2(int n){
        int f1 = 1;
        int f2 = 1;
        int temp = 0;
        while( n > 2){
            temp = f2;
            f2 = f1+f2;
            f1 = temp;
            n--;
        }
        return f2;
    }

    //时间复杂度o(logn)
    public int f3(int n){
        if(n < 0)
            return -1;
        if( n == 1 || n == 2)
            return 1;
        int[][] base  = {{1,1},{1,0}};
        int[][] res = matrixPower(base,n-2);
        return res[0][0]+res[1][0];
    }

    //计算base矩阵的p次方
    private int[][] matrixPower(int[][] base, int p) {
        int n = base[0].length;
        int[][] res = new int[n][n];
        //构建单位矩阵
        for(int i = 0 ; i < n ; i++)
            res[i][i] = 1;
        int[][] temp = base;
        /**
         *        采用计算m的n次方的思想, 如 m = 2, n = 6
         *        6的二进制为0110,即 2^6 = 2^2*2^4
         *        14的二进制为1110 即 2^14 = 2^8*2^4*2^2
         *        此方法同理可计算矩阵base的p次方.
         */
        for(;p > 0; p>>=1){
            if((p & 1) == 1)
                res = multiMatrix(res,temp);
            temp = multiMatrix(temp,temp);
        }
        return res;
    }
    //矩阵相乘
    private int[][] multiMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for(int i = 0 ; i < m1.length; i++)
            for(int j = 0 ; j < m2[0].length;j++)
                for(int k = 0 ; k < m2.length;k++)
                    res[i][j] += m1[i][k]*m2[k][j];
        return res;
    }

    //计算m的n次方
    public int f4(int m , int n){
        int res = 1;
        for(;n>0;n>>=1){
            if((n&1)== 1)
                res = power(res,m);
            m = power(m,m);
        }
        return res;
    }

    private int power(int res, int n) {
        return res*n;
    }




    public static void main(String[] args) {
        DP02 test = new DP02();
        System.out.println("o(2^n)---------->"+test.f1(8));
        System.out.println("o(n)------------>"+test.f2(8));
        System.out.println("o(logn)------------>"+test.f3(8));
        System.out.println("o------------>"+test.f4(2,6));

    }
}
