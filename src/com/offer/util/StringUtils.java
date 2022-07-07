package com.offer.util;

/**
 * @Author: zz
 * @Date: 2022/6/12 16:54
 */
public class StringUtils {

    public static boolean isEmpty(String str){
        return str == null || str.length() <= 0;
    }


    public static boolean isEmpty(String[] str){
        return str == null || str.length <= 0;
    }
}
