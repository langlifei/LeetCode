package com.offer.sword;

/*
*                               时间:2020年3月6日11:00:10
*                               地点:湖北省仙桃市
*                               问题:返回斐波拉契数列的第n位
*                               通过率:递归通不过,循环可以.
*                               原因:递归的时间复杂度太高
* */

public class Fibonacci07 {

    //使用递归,但由于时间开销太大,通过不了.
    public int Fibonacci(int n) {
        if(n > 39)
            return -1;
        if(n < 0)
            return 0;
        if(n == 1)
            return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    public int Fibonacci1(int n){
        if(n > 39)
            return 0;
        if( n == 0 )
            return 0;
        int i = 0 , j = 1;
        int temp = 1;
        while(n>1){
            temp = i+j;
            i = j;
            j = temp;
            n--;
        }
        return temp;
    }

    public static void main(String[] args){
        Fibonacci07 f = new Fibonacci07();
        System.out.println(f.Fibonacci1(1));
    }
}
