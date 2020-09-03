package com.offer.codingInterviewGuide.string;

/**
 * @Author Zeng Zhuo
 * @Date 2020/9/2 8:35
 * @Describe
 */

class String04 {

    public boolean isNumber(String s){
        if( s == null || s.length() <= 0 )
            return false;
        String[] strs =  s.split("e");
        if(strs.length>2)
            return false;
        boolean flag = true;
        if(strs.length == 2)
            flag = checkNumber(strs[1]);
        int start = 0;
        String s1 = strs[0];
        char c = s1.charAt(0);
        if(!Character.isDigit(c) && (c != '+' || c != '-'))
            return false;
        if( c == '+' || c == '-')
            start = 1;
        return checkFirstNumber(s1,start)&&flag;
    }

    private boolean checkFirstNumber(String s1, int start) {
        char c = ' ';
        for(int i = start ; i < s1.length() ; i++){
            c = s1.charAt(i);
            if(!Character.isDigit(c)){
                if( i == 0 || i == s1.length()-1)
                    return false;
                if( c != '.')
                    return false;
            }
        }
        return true;
    }

    private boolean checkNumber(String str) {
        if(str == null || str.length() <= 0)
            return false;
        if(!Character.isDigit(str.charAt(0)) && str.charAt(0)!='-')
            return false;
        char c = ' ';
        for(int i = 0 ; i < str.length() ; i++){
            c = str.charAt(i);
            if(!Character.isDigit(c) && i == 0 && c != '-')
                return false;
            if( i == 0 && c == '+')
                continue;
            if(!Character.isDigit(c))
                return false;
        }
        return true;
    }
}
