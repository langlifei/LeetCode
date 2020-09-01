package com.offer.leetcode.sword.hard;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/13 15:32
 * @Describe
 */

public class 正则表达式匹配19 {

    public boolean isMatch(String s, String p) {
        if(s.equals(p))
            return true;
        int j = 0;
        for(int i = 0 ; i < s.length()&&j<p.length();i++,j++){
            if(s.charAt(i)!=p.charAt(j)){
                //如果后一个不是*，则返回false
                //*号匹配0个
                if(j+1<p.length()&&p.charAt(j+1)=='*'){
                    j++;
                }else if(p.charAt(j)!='.')
                    return false;
            }else{
                //如果j的下一个是*号，则匹配多个
                if(j+1<p.length()&&p.charAt(j+1)=='*'){
                    while(i<s.length()&&s.charAt(i+1)==p.charAt(j))
                        i++;
                    j++;
                }
            }
        }
        return true;
    }
}
