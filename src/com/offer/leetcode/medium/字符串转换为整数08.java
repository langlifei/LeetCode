package com.offer.leetcode.medium;

/**
 *              时间:2020年4月13日13:55:12
 *              题解:1.判断是否溢出
 *                   2.将字符转为数字
 */

public class 字符串转换为整数08 {

    public static int myAtoI(String str){
      int i = 0;
      boolean f = true;
      int number = 0;
      int m = 0;
      boolean k = false;
      for(;i<str.length();i++){
          if (str.charAt(i)!=' '){
              break;
          }
      }
      for(;i<str.length();i++){
          char c = str.charAt(i);
          if(f&&c=='+'){
              f =false;
              k = true;
              continue;
          }
          else if(f&&c=='-'){
              f = false;
              continue;
          }
          if (Character.isDigit(c)){
              if((number*10)/10!=number)
                  return k?Integer.MIN_VALUE:Integer.MAX_VALUE;
              number=number*10+c-'0';
          }else
              return k?-number:number;
      }
        return k?-number:number;
    }

    public static void main(String... args){
        System.out.println(myAtoI("+-2"));
    }
}
