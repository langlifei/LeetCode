package com.offer.leetcode.medium;

/**
 * @Description:
 * 有一个书店老板，他的书店开了 n 分钟。每分钟都有一些顾客进入这家商店。给定一个长度为 n 的整数数组 customers ，其中 customers[i] 是在第 i 分钟开始时进入商店的顾客数量，所有这些顾客在第 i 分钟结束后离开。
 *
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
 *
 * 当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。
 *
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 minutes 分钟不生气，但却只能使用一次。
 *
 * 请你返回 这一天营业下来，最多有多少客户能够感到满意 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/grumpy-bookstore-owner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Example:
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
 * 输出：16
 * 解释：书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/grumpy-bookstore-owner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zz
 * @Date: 2022/6/13 21:28
 */
class Solution1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int start = 0;
        int tempStart = start;
        int maxWindowValue = 0;
        for(int i = 0 ; i < minutes ; i++){
            maxWindowValue += customers[i] * grumpy[i];
        }
        int currentWindow = maxWindowValue;
        for (int i = minutes; i < customers.length; i++) {
            //由于当前窗口的值为0,1,2的和，故只需-0的值+3的值，即为1,2,3的和。
            currentWindow = currentWindow - customers[i - minutes] * grumpy[i - minutes] + customers[i] * grumpy[i];
            if(currentWindow > maxWindowValue){
                tempStart = i - minutes;
                maxWindowValue = currentWindow;
            }
        }
        int res = 0;
        for(int i = 0 ; i < customers.length ; i++){
            //在最大的滑动窗口内时，加上所有的顾客
                res += grumpy[i] == 0 ? customers[i] : 0;
        }
        return res + maxWindowValue;
    }


    public static void main(String[] args) {
        System.out.println(new Solution1052().maxSatisfied(new int[]{3}, new int[]{1}, 1));
    }
}
