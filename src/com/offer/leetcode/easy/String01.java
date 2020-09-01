package com.offer.leetcode.easy;

/*
*                   时间:2020年3月4日13:06:52
*                   地点:湖北省仙桃市
*                   问题:判断是否为回文窜.
*                   通过率:100%
*
* */
public class String01 {
    public boolean isPalindrome(String s) {
        //先将字符窜变为连续,只取数字和字母
        StringBuffer str = new StringBuffer();
        char temp = ' ';
        for(int i = 0 ; i < s.length();i++){
            temp = s.charAt(i);
            if(Character.isLetterOrDigit(temp))
                str.append(temp);
        }
        //判断字符是否为回文窜
        for(int i = 0 , j = str.length()-1; i < j;i++,j--){
            //忽略大小写
            if(Character.toLowerCase(str.charAt(i))!=Character.toLowerCase(str.charAt(j)))
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        String01 s = new String01();
        System.out.println(s.isPalindrome("  "));
    }
}
