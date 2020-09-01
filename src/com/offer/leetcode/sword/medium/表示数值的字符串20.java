package com.offer.leetcode.sword.medium;

import javax.xml.stream.events.Characters;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/12 23:16
 * @Describe 不能打补丁，可使用有限状态自动机
 */

public class 表示数值的字符串20 {
    public boolean isNumber(String s){
        char c = ' ';
        s = s.trim();
        for(int i = 0 ; i < s.length();i++){
            c = s.charAt(i);
            if(!Character.isDigit(c)){
                if(i!=0&&(c!='e'&&c!='.')){
                    return false;
                }else if(i==0&&(c!='+'&&c!='-'&&c!='.')) {
                    return false;
                }
                else if(i!=0&&c=='e'){
                    if(i==s.length()-1)
                        return false;
                    else
                        return f1(s.substring(i+1));
                }
            }
        }
        return true;
    }

    private boolean f1(String substring) {
        for(int i = 0 ; i < substring.length();i++)
            if(!Character.isDigit(substring.charAt(i)))
                return false;
        return true;
    }

    public static void main(String[] args) {
        表示数值的字符串20 test = new 表示数值的字符串20();
        System.out.println(test.isNumber("5e2"));
    }
}
