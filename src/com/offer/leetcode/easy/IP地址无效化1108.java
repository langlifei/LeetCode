package com.offer.leetcode.easy;

/**
 * @Description:
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 * @Example:
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * @Author: zz
 * @Date: 2022/6/21 12:16
 */
class Solution1108 {

    public String defangIPaddr(String address) {
        return replaceAll(address,'.',"[.]");
    }

    private String replaceAll(String data, Character source, String target) {
        char[] chars = data.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char aChar : chars) {
            if (aChar != source) {
                result.append(aChar);
            } else {
                result.append(target);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution1108().defangIPaddr("1.1.1.1"));
    }
}
