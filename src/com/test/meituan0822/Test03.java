package com.test.meituan0822;

import java.util.Scanner;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/22 17:29
 * @Describe
 */

public class Test03 {

    public static int[] f(String[] strings,int n) {
        int[] temp = new int[n];
        for(int i = 0 ; i < strings.length ;i++)
            temp[i] = Integer.parseInt(strings[i]);
        return temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();
        int n = Integer.parseInt(s1);
        String[] tempS2 = s2.split(" ");
        String[] tempS3 = s3.split(" ");
        int[] m1 = f(tempS2,n);
        int[] m2 = f(tempS3,n);
        Test03 test = new Test03();
        test.test(n,m1,m2);
    }

    public void test(int n, int[] m1, int[] m2) {

        int left = 0 ;
        int right = 0;
        for(int i = 0 ; i < m2.length; i++){
            left = sum(m1,0,m2[i]-1);
            right = sum(m1,m2[i],m2.length);
            m1[m2[i]-1] = 0;
            System.out.println(left > right ? left : right);
        }
    }

    public int sum(int[] m , int start , int end){
        int sum = 0;
        for(int i = start ; i < end ; i++)
            sum += m[i];
        return sum;
    }
}
