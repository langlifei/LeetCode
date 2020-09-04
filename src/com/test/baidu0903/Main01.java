package com.test.baidu0903;

import java.util.Scanner;

/**
 * @Author Zeng Zhuo
 * @Date 2020/9/3 19:42
 * @Describe
 */

public class Main01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        String[] s = str.split(" ");
        int[] array = new int[s.length];
        for(int i = 0 ; i < s.length; i++)
            array[i] = Integer.parseInt(s[i]);
        Main01 test01 = new Main01();
        System.out.println(test01.findMax(array));
    }

    private long findMax(int[] array) {
        if( array == null || array.length <= 0 )
            return -1;
        int fiveCount = 0;
        int zeroCount = 0;
        for (int i = 0 ; i < array.length ; i++)
            if(array[i] == 5)
                fiveCount++;
            else if(array[i] == 0)
                zeroCount++;
        if(zeroCount == 0 || fiveCount == 0)
            return -1;
        long temp = 1;
        for(int i = 0 ; i < zeroCount ; i++)
            temp*=10;
        long res = 0;
        long max = res;
        for(int i = 0 ; i < fiveCount; i++){
            res = 5 * temp + res;
            if(res % 90 == 0 && res > max)
                max = res;
            temp *= 10;
        }
        return max==0?-1:max;
    }
}
