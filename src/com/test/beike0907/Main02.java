package com.test.beike0907;

import java.util.Scanner;
public class Main02 {

    public int f(String str){
        if(str == null || str.length()<=0)
            return 0;
        else if(str.length() <= 3)
            return str.length();
        int steps = 2;
        int used = 0; //0表示未使用， 1 表示已使用，2 表示不能连续使用
        String temp = "";
        for(int i = 2 ; i < str.length();i++){
            if(used == 0 && (i+i-1)<str.length() && str.substring(0,i-1).equals(str.substring(i,i+i-1))){
                used = 1;
                temp = str.substring(0,i-1);
                i = i+i-1;
            }
            if(used == 1 && i+temp.length() < str.length() && temp.equals(str.substring(i,i+temp.length())))
                i = i+temp.length();
            else if(used == 1)
                used = 2;
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String str = in.nextLine();
        Main02 main02 = new Main02();
        System.out.println(main02.f(str));
    }
}