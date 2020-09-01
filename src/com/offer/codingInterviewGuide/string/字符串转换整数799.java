package com.offer.codingInterviewGuide.string;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/19 10:39
 * @Describe
 */

class String02 {
    public int myAtoi(String str) {
        if(str==null)
            return 0;
        str = str.trim();
        if(str.length()<=0)
            return 0;
        if(str.charAt(0)!='-' && str.charAt(0)!='+'&& !Character.isDigit(str.charAt(0)))
            return 0;
        boolean flag = true;
        if(!Character.isDigit(str.charAt(0)))
            flag = false;
        long result = convert(flag?str:str.substring(1));
        if(str.charAt(0)=='+')
            flag = true;
        if(result>Integer.MAX_VALUE)
            return flag?Integer.MAX_VALUE:Integer.MIN_VALUE;
        return flag?(int)result:-(int)result;
    }

    private long convert(String str) {
        if(str==null || str.length()<=0)
            return 0;
        long result = 0;
        for(int i = 0 ; i < str.length()&&Character.isDigit(str.charAt(i));i++){
            result = result * 10 + (str.charAt(i)-'0');
            if(result>Integer.MAX_VALUE)
                return result;
        }
        return result;
    }

    public static void main(String[] args) {
        String02 test = new String02();
        System.out.println(test.myAtoi("-2147483647"));
    }
}
