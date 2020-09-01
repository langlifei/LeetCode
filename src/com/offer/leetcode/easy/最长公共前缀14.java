package com.offer.leetcode.easy;

/**
 *             key:水平扫描法通过逐步比较，将比较范围逐步缩小。A∩B∩C = (A∩B)∩C,即先逐步求解。
 */


public class 最长公共前缀14 {

    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i = 1 ; i < strs.length;i++){
            //==0时表示prefix已经和当前strs[i]匹配了。
            while(strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0,prefix.length()-1);//如果字符串不能匹配，则减少字符串的长度
                //如果prefix的的第一个字符都无法匹配，那么返回空。
                if(prefix.length()==0)
                    return "";
            }
        }
        return prefix;
    }
}
