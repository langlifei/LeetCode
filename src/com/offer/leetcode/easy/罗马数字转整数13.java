package com.offer.leetcode.easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class 罗马数字转整数13 {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int number = 0;
        //对0-n-1个罗马数字进行处理
        if(s.length()==0)
            return 0;
        char c ;
        int j,i;
        for(i = 0 ; i < s.length()-1;i++){
            c = s.charAt(i);
            j = map.get(c);
            if(j>=map.get(s.charAt(i+1)))
                number+=j;
            else
                number-=j;
        }
        number+=map.get(s.charAt(i));
        return number;
    }
}
