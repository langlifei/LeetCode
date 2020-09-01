package com.offer.codingInterviewGuide.recurrenceAndDP;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/21 13:19
 * @Describe
 */

class DP11 {


    //峰谷法
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 0)
            return 0;
        int n = prices.length;
        int i = 0;
        int profit = 0;
        int valley = 0;
        int peek = 0;
        while( i + 1 < n ){ //三个循环的判断得相等,否则会造成死循环. 此方法有点类似于快速排序进行交换时寻找左右两个结点.
            //找到谷值
            while(i + 1 < n && prices[i]>=prices[i+1])
                i++;
            valley = prices[i];
            //找到峰值
            while( i + 1 < n && prices[i]<=prices[i+1])
                i++;
            peek = prices[i];
            profit += peek - valley;
        }
        return profit;
    }

    public static void main(String[] args) {
        DP11 test = new DP11();
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(test.maxProfit(prices));
    }
}
