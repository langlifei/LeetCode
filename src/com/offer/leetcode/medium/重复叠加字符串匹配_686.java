package com.offer.leetcode.medium;

class Leetcode_686 {

    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        int ans = 1;
        //考虑边界:从重复的第一个a的最后一个字符开始匹配，匹配完最后一个字符恰好是最后一个a的第一个字符。则最大字符数可能为(a.len() - 1) + b.len() + (a.len() - 1) = 2 * a.len() + b.len() - 2
        int max =  2 * a.length() + b.length() -2 ;
        while(sb.length() <= max){
            if(sb.toString().contains(b)){
                return ans;
            }else{
                sb.append(a);
                ans++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_686().repeatedStringMatch("abc", "cabcabca"));
    }
}
