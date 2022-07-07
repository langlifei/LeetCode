package com.offer.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author: zz
 * @Date: 2022/6/16 15:19
 */
class Solution532 {

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if( i + 1 < len && nums[ i + 1 ] == nums[i]){
                if( k == 0 ){
                    if(i == 0){
                        res++;
                    }else if(nums[i-1] != nums[i]){
                        res ++ ;
                    }
                }
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                if( j + 1 < len && nums[ j + 1 ] == nums[j]){
                    continue;
                }
                if(nums[j] - nums[i] == k){
                    res ++;
                }
            }
        }
        return res;
    }
}
