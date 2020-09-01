package com.offer.leetcode.sword.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/8 12:12
 * @Describe 利用转义字符串的思想来解题。
 */

public class Test {
    private final static char T= 'A';
    private final static int DISTANCE = 18;

    public String transform1(String s){
        char c = ' ';
        StringBuilder str = new StringBuilder();
        for(int i = 0,j = 0; i < s.length();i++,j++){
            c = s.charAt(i);
            if(Character.isDigit(c)){
                str.insert(j,T);
                j++;
                str.insert(j, (char) (c+DISTANCE));
            }else{
                if(c=='A')
                {
                    str.insert(j,T);
                    j++;
                }
                str.insert(j,c);
            }
        }
        return str.toString();
    }

    public String transform2(String s){
        StringBuilder str = new StringBuilder();
        char c = ' ';
        for(int i = 0 ,j = 0; i < s.length();i++,j++){
            c = s.charAt(i);
            if(c==T&&i<s.length()-1){
                i++;
                c = s.charAt(i);
                if(c!=T)
                    c -= DISTANCE;
            }
            str.insert(j,c);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.transform1("ASF123A32B23GAS23AF234AFBDFQ12313123ADF123"));
    }
}
