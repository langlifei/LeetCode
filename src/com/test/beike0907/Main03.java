package com.test.beike0907;

import java.util.Scanner;
public class Main03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        String[] strs1 = str1.split(" ");
        int[] hp = new int[strs1.length];
        for(int i = 0 ; i < strs1.length ; i++)
            hp[i] = Integer.parseInt(strs1[i]);
        String[] strs2 = str2.split(" ");
        int[] rHp = new int[strs2.length];
        for(int i = 0 ; i < strs2.length ; i++)
            rHp[i] = Integer.parseInt(strs2[i]);
        Main03 main03 = new Main03();
        System.out.println(main03.f(hp, rHp));
    }

    private int f(int[] hp, int[] rHp) {
        if( hp == null || rHp == null)
            return 0;
        int len = hp.length / 2;
        int res = 0;
        int i = len-1;
        int j = len;
        int minRes = Integer.MAX_VALUE;
        while( i >= 0 && j <hp.length){
            if((rHp[i]-hp[i]) >= (rHp[j]-hp[j])){
                res += rHp[i]-hp[i];
                i--;
            }else{
                res += rHp[j]-hp[j];
                j++;
            }
            if(res < minRes)
                minRes = res;
        }
        while( i >= 0 ){
            res += rHp[i]-hp[i--];
            if(res < minRes)
                minRes = res;
        }
        while( j < hp.length ){
            res += rHp[j]-hp[j++];
            if(res < minRes)
                minRes = res;
        }
        return Math.abs(minRes)+1;
    }
}
