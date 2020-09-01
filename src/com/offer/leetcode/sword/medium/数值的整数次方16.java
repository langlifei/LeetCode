package com.offer.leetcode.sword.medium;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/13 14:38
 * @Describe  1.存储x的n/2次方的值，重复使用，减少计算。
 *            2.int的最小值-2147483648，转换为正数时会超出int的最大值范围，需强转为long类型。
 */

public class 数值的整数次方16 {

    public double myPow(double x, int n) {
        if(n>0)
            return f(x,n);
        else if(n == 0)
            return 1;
        else
            return 1/f(x,-(long)n);
    }

    private double f(double x, long n) {
        double sum = 1.0;
        double temp = 0.0;
        if(n > 1024){
            temp = f(x,n/2);
            if(n % 2 == 0)
                return temp*temp;
            else
                return temp*temp*x;
        }
        while(n>0){
            sum *=x;
            n--;
        }
        return sum;
    }

    public static void main(String[] args) {
        数值的整数次方16 test = new 数值的整数次方16();
        System.out.println(test.myPow(2.00000, Integer.MIN_VALUE));
    }
}
