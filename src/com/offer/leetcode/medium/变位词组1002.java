package com.offer.leetcode.medium;

import java.util.*;

/**
 * @Author: zz
 * @Date: 2022/7/4 13:17
 */
class Solution1002 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> sortMap = new HashMap<>();
        for (String str : strs) {
            String temp = stringSort(str);
            List<String> stringList = sortMap.get(temp);
            if(stringList == null){
                stringList = new ArrayList<>();
                sortMap.put(temp,stringList);
            }
            stringList.add(str);
        }
        for (Map.Entry<String, List<String>> stringListEntry : sortMap.entrySet()) {
            result.add(stringListEntry.getValue());
        }
        return result;
    }

    public String stringSort(String target){
        char[] chars = target.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
