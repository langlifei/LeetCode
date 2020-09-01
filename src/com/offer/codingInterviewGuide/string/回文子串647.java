package com.offer.codingInterviewGuide.string;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/19 10:32
 * @Describe
 */

class String01 {
    public int countSubstrings(String s) {
        if(s == null || s.length() <= 0)
            return 0;
        int l ,r ;
        int ans = 0;
        //使用中心扩展,其可能出现的中心点为2*n-1,原因是字符串可能是偶数,也可能是奇数.
        for(int i = 0 ; i < 2 * s.length() - 1; i++){ // 枚举出所有可能出现的中心点
            l = i / 2; r = i / 2 + i % 2; //左右初始值
            while( l>=0 && r < s.length() && s.charAt(l) == s.charAt(r) ){
                l--;//向左扩展
                r++;//向右扩展
                ans++;
            }
        }
        return ans;
    }
}
