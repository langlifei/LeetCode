package com.offer.leetcode.medium;

/*
                起始时间：2020年3月11日21:06:31
                结束时间：2020年3月11日22:00:52
                结果：(875ms,5.02%);(42mb,5.01%)


 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubString02 {
    public int lengthOfLongestSubstring(String s){
        int maxLength = 0;
        for(int i = 0 ; i < s.length();i++){
            StringBuffer str = new StringBuffer();
            str.append(s.charAt(i));
            for(int j = i+1 ; j < s.length();j++){
                if(!isContain(str.toString(),s.charAt(j)))
                    str.append(s.charAt(j));
                else
                    break;
            }
            if(str.length()>maxLength)
                maxLength = str.length();
        }
        return maxLength;
    }

    //字符串中是否包含指定字母
    public boolean isContain(String str,char x){
        for(int i = 0 ; i < str.length();i++)
            if(str.charAt(i)==x)
                return true;
            return false;
    }

    /**
     * @result (10ms,64.71%);(41.7mb,5.00%);
     * @param
     * @return
     */
    public int lengthOfLongestSubstring1(String s){
        int l = 0 ;
        int r = 0 ;
        //采用hashSet作为其存储结构
        Set set = new HashSet();
        int length = s.length();
        int maxLength = 0;
        while(l<length&&r<length){
            if(!set.contains(s.charAt(r))){
                set.add(s.charAt(r++));
                maxLength = Math.max(maxLength,r-l);
            }else{
                set.remove(s.charAt(l++));
            }
        }
        return maxLength;
    }

    /**
     * @E 使用hashMap存储其下标，当重复时可直接通过取值可知道其重复的数所在字符串中的下标。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(new LengthOfLongestSubString02().lengthOfLongestSubstring("abcsegsdfsdsf"));
        System.out.println(new LengthOfLongestSubString02().lengthOfLongestSubstring1("bbbbbbbbb"));
    }


}
