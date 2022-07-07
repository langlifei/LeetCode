package com.offer.leetcode.medium;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: zz
 * @Date: 2022/6/15 12:19
 */
class Solution473 {

    public boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);
        //寻找边长
        int sum = Arrays.stream(matchsticks).sum();
        if(sum % 4 != 0){
            return false;
        }
        int target = sum / 4;
        int max = Arrays.stream(matchsticks).max().getAsInt();
        if( max > target){
            return false;
        }
        int count = 0;
        int right = matchsticks.length - 1;
        while(target == matchsticks[right]){
            count++;
            right--;
        }
        int left = 0;
        if((right - left) % 2 == 0){
            return false;
        }
        while(left < right){
            if(matchsticks[left] + matchsticks[right] == target){
                count++;
            }else{
                return false;
            }
            left++;
            right--;
        }
        return count == 4;
    }

    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>(20);
        objects.add("1");
        objects.add("1");
        objects.add("1");
        objects.add("1");
        objects.add("1");
        Iterator<Object> iterator = objects.iterator();
        HashMap map = new HashMap();
        for (Object object : objects) {
//            objects.add("2");
        }
        System.out.println(objects.size());
    }
}
