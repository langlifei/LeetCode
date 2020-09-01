package com.test.meituan0822;

import java.util.Scanner;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/22 16:02
 * @Describe
 *
 *  小美是美团的前端工程师，为了防止系统被恶意攻击，小美必须要在用户输入用户名之前做一个合法性检查，
 *  一个合法的用户名必须满足以下几个要求：
 *
 * 1.    用户名的首字符必须是大写或者小写字母。
 *
 * 2.    用户名只能包含大小写字母，数字。
 *
 * 3.    用户名需要包含至少一个字母和一个数字。
 *
 * 如果用户名合法，请输出“Accept”，反之输出“Wrong”
 *
 * 输入:输入第一行包含一个正整数T，表示需要检验的用户名数量。(1<=T<=100)
 *
 * 接下来有T行，每行一个不超过20的字符串s，表示输入的用户名。
 *
 * 输出: 对于每一个输入的用户名s，请输出一行，即按题目要求输出一个字符串。
 */

class Main01 {

    public String test01(String str){
        if(str == null || str.length() <= 0)
            return "Wrong";
        if(!Character.isLetter(str.charAt(0)))
            return "Wrong";
        boolean isAllLetter = true;
        boolean isAllDigit = true;
        char c = ' ';
        for(int i = 1 ; i < str.length();i++){
            c = str.charAt(i);
            if(!Character.isLetterOrDigit(c))
                return "Wrong";
            if(!Character.isLetter(c))
                isAllLetter = false;
            if(!Character.isDigit(c))
                isAllDigit = false;
        }
        return isAllDigit||isAllLetter?"Wrong":"Accept";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] strings = new String[n];
        for(int i = 0 ; i < strings.length; i++)
            strings[i] = sc.nextLine();
        Main01 main01 = new Main01();
        for(int i = 0 ; i < strings.length ; i++)
            System.out.println(main01.test01(strings[i]));
    }

}
