package com.offer.leetcode.medium;


/**
 * @Author Zeng Zhuo
 * @Date 2020/8/13 22:23
 * @Describe
 */

class String01 {

    public String multiply(String num1, String num2) {
        if(num1==null||num1.length()<=0||num1.equals("0")||num2==null||num2.length()<=0||num2.equals("0"))
            return "0";
        String temp = "";
        String sum = "";
        for(int i = num2.length()-1; i>=0;i--){
            temp = multiNum(num1,num2.charAt(i)-'0',num2.length()-1-i);
            sum = add(sum,temp);
        }
        return sum;
    }

    private String add(String sum, String temp) {
        int flag = 0,t=0;
        int i , j;
        String n = "";
        for(i = sum.length()-1,j = temp.length()-1; i >= 0 && j >=0 ; i--,j--){
            t = (sum.charAt(i)-'0')+(temp.charAt(j)-'0')+flag;
            if(t>=10){
                flag = 1;
                t%=10;
            }else
                flag = 0;
            n = t + n;
        }
        while(i>=0){
            t = (sum.charAt(i)-'0')+flag;
            if(t>=10){
                flag = 1;
                t%=10;
            }else
                flag = 0;
            n = t + n;
            i--;
        }
        while(j>=0){
            t = (temp.charAt(j)-'0')+flag;
            if(t>=10){
                flag = 1;
                t%=10;
            }else
                flag = 0;
            n = t + n;
            j--;
        }
        return flag==0?n:flag+n;
    }

    private String multiNum(String num,int p,int t) {
        if(p==0)
            return "0";
        int n;
        int q = 0;
        String sum = "";
        for(int i = num.length()-1,j=1;i>=0;i--,j*=10){
            n = (num.charAt(i)-'0')*p+q;
            if(n >= 10){
                q = n / 10;
                n %= 10;
            }else
                q = 0;
            sum = n+sum;
        }
        sum = q==0?sum:q+sum;
        while(t>0){
            sum+="0";
            t--;
        }
        return sum;
    }

    public static void main(String[] args) {
        String01 test = new String01();
        System.out.println(test.multiply("6913259244","71103343"));
    }
}
