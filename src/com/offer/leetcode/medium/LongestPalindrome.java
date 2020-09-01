package com.offer.leetcode.medium;

public class LongestPalindrome {
    public static String longestPalindrome(String s){
        if(s.length()==1)
            return s;
        int maxlen = 0;
        String maxStr ="";
        int i = 0 ;
        int j = s.length();
        while(i<j&&j-i>maxlen){
            while(i<j&&!isPalidrome(s.substring(i,j))){
                j--;
            }
            if(maxlen<j-i){
                maxlen = j-i;
                maxStr = s.substring(i,j);
            }
            j = s.length();
            i++;
        }
        return maxStr;
    }

    public static boolean isPalidrome(String s){
        for(int i= 0, j = s.length()-1;i<j;i++,j--)
            if(s.charAt(i)!=s.charAt(j))
                return false;
        return true;
    }

    public static void main(String[] args){
        System.out.println(longestPalindrome("abb"));
    }
}
