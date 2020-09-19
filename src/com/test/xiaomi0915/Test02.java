package com.test.xiaomi0915;



import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test02 {


    public String f(String str){
        if(str == null || str.length() <= 0)
            return str;
        Set<Character> set= new HashSet<>();
        StringBuilder strings = new StringBuilder();
        char[] chars = str.toCharArray();
        char c = ' ';
        for(int i = 0 ; i < chars.length; i++){
            c = chars[i];
            if(set.contains(c))
                continue;
            else
                set.add(c);
            strings.append(chars[i]);
        }
        return strings.toString();
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(test02.f(str));
    }
}
