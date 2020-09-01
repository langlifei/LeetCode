package com.offer.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author Zeng Zhuo
 * @Date 2020/5/25 23:09
 * @Describe key:对下标进行更新,当长度不确定时使用递归。
 */

public class 电话号码的字母组合17 {
    private static Map<Character,String> map = new HashMap<>();

    static {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> restore = new LinkedList<>();
        if(digits.length()<=0)
            return restore;
        List<String> temp = new LinkedList<>();
        //找出需要组合的字符串
        for(int i = 0 ; i < digits.length();i++)
            temp.add(map.get(digits.charAt(i)));
        int[] array = new int[temp.size()];
        for(int i = 0 ; i < array.length;i++)
            array[i] = 0;
        while(array[0]<temp.get(0).length()){
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0;i<array.length;i++){
                stringBuilder.append(temp.get(i).charAt(array[i]));
            }
            restore.add(stringBuilder.toString());
            //从最后开始，更新下标
            updateIndex(array,array.length-1,temp);
        }
        return restore;
    }

    private void updateIndex(int[] array,int index, List<String> list){
        if(index == array.length-1)
            array[index]++;
        if(index<=0)
            return ;
        if(array[index]==list.get(index).length()){
            array[index] = 0;
            array[index-1]++;
        }
        updateIndex(array,index-1,list);
    }

    public static void main(String[] args) {
        电话号码的字母组合17 test = new 电话号码的字母组合17();
        System.out.println(test.letterCombinations("2"));
    }
}
