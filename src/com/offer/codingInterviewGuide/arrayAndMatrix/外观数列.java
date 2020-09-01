package com.offer.codingInterviewGuide.arrayAndMatrix;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/21 9:58
 * @Describe
 */

class Array03 {

    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        String prev = countAndSay(n-1);
        String res = "";
        int count = 1;
        for(int i = 0 ; i < prev.length(); i++){
            while(i + 1 < prev.length() && prev.charAt(i)==prev.charAt(i+1)){
                i++;
                count++;
            }
            res += "" + count + prev.charAt(i);
            count = 1;
        }
        return res;
    }
}
