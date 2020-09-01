package com.offer.sword;


/*
*               时间:2020年3月3日12:22:21
*               地点:湖北省仙桃市
*               问题:请实现一个函数，将一个字符串中的每个空格替换成“%20”。
*                    例如，当字符串为We Are Happy.则经过替换之后的字符串
*                    为We%20Are%20Happy
*               通过率:100%
* */
public class String02 {

    public String replaceSpace(StringBuffer str) {
        for(int i = 0 ; i < str.length();i++){
            if(str.charAt(i) == ' '){
                str.setCharAt(i,'%');
                str.insert(i+1,"20");
            }
        }
        return str.toString();
    }

    public static void  main(String[] args){
        String02 s = new String02();
        String str = s.replaceSpace(new StringBuffer(" We are happy "));
        System.out.println(str);
    }
}
