package com.offer.codingInterviewGuide.recurrenceAndDP;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/15 16:16
 * @Describe
 */

class DP05 {

    //通过率80%
    public int maxSubArray1(int[] nums) {
        if(nums==null || nums.length<=0)
            return 0;
        else if(nums.length == 1)
            return nums[0];
        Deque<Integer> deque = new LinkedList<>();
        int max = nums[0],sum = nums[0];
        deque.addFirst(max);
        for(int i = 1; i < nums.length ; i++){
            deque.addLast(nums[i]);
            sum += nums[i];
            if(sum>max)
                max = sum;
            while(nums[i]>deque.getFirst()){
                sum -= deque.getFirst();
                deque.removeFirst();
                if(sum>max)
                    max = sum;
            }
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length<=0)
            return 0;
        else if(nums.length == 1)
            return nums[0];
        //使用动态规划....f(i) = max(f(i-1)+nums[i],nums[i])
        int pre = 0 , max = nums[0];
        for(int i = 0 ; i < nums.length ; i++){
            pre = Math.max(pre+nums[i],nums[i]);//如果之前数的和加上当前数比当前数小,则结果为当前数
            max = Math.max(max,pre);//从f[i](i=0...nums.length)中找出最大的f[i]
        }
        return max;
    }

    public static void main(String[] args) {
        DP05 test = new DP05();
        System.out.println(test.maxSubArray1(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
