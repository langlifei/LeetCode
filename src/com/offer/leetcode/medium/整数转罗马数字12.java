package com.offer.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *                 时间:2020年4月13日23:37:59
 *                 题解:使用贪心策略,每次取最大的,大的取完后取次大的...
 */

public class 整数转罗马数字12 {

    /**
     * 暴力破解.
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        List<Integer> list = new ArrayList<>();
        while(num!=0){
            list.add(num%10);
            num/=10;
        }
        String str = "";
        for(int i = list.size()-1;i>=0;i--){
            switch (i){
                case 0:str+=f1(list.get(i),'I','V','X');
                        break;
                case 1:str+=f1(list.get(i),'X','L','C');
                        break;
                case 2:str+=f1(list.get(i),'C','D','M');
                        break;
                case 3:int m = list.get(i);
                       while(m>0){
                           str+='M';
                           m--;
                       }
                       break;
            }
        }
        return str;
    }

    public static String f1(int i, char l , char m , char r){
        String str = "";
        if(i>0&&i<4){
            while(i>0){
                str+=l;
                i--;
            }
        }
        else if(i==4)
            str = ""+l+m;
        else if(i==5)
            str = ""+m;
        else if(i>5&&i<9){
            str +=m;
            while(i>5){
                str+=l;
                i--;
            }
        }else if(i==9)
            str = ""+l+r;
        return str;
    }

    public static void main(String[] args){
        System.out.println(intToRoman(1994));
    }

    /**
     * 解法2 贪心策略
     * @param num
     * @return
     */
    public String intToRoman2(int num) {
            // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
            // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
            int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

            StringBuilder stringBuilder = new StringBuilder();
            int index = 0;
            while (index < 13) {
                // 特别注意：这里是等号
                while (num >= nums[index]) {
                    // 注意：这里是等于号，表示尽量使用大的"面值"
                    stringBuilder.append(romans[index]);
                    num -= nums[index];
                }
                index++;
            }
            return stringBuilder.toString();
        }
}
