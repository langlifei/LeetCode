package com.offer.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zz
 * @Date: 2022/7/4 13:04
 */
class Solution1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        //寻找最小绝对差
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int temp = Math.abs(arr[i] - arr[i-1]);
            if(temp < min){
                min = temp;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1] + min == arr[i]){
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                result.add(temp);
            }
        }
        return result;
    }
}
