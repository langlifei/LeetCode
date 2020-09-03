package com.offer.codingInterviewGuide.arrayAndMatrix;

import java.util.*;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/31 21:15
 * @Describe
 */

class Array10 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List> map = new HashMap<>();
        char[] chars = null;
        String temp = null;
        for(String s : strs){
            chars = s.toCharArray();
            Arrays.sort(chars);
            temp = String.valueOf(chars);
            if(!map.containsKey(temp))
                map.put(temp,new ArrayList<String>());
            map.get(temp).add(s);
        }
        return new ArrayList(map.values());
    }
}
