package com.test.xiaomi0915.xiaomi1m;

public class Test01 {

    public String f1(String string){
        if(string == null || string.length() <= 0)
            return null;
        StringBuilder str = new StringBuilder(string);
        int i = 0 ;
        while(i>=0 && i < str.length()){
            if(i>0&&str.charAt(i)=='i'&&str.charAt(i-1)=='m'){
                str.deleteCharAt(i);
                str.deleteCharAt(i-1);
                i-=2;
            }
           i++;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        System.out.println(test01.f1("ammmimmmmmmimimiiiiiiiiad"));
    }
}
