package com.offer.codingInterviewGuide.arrayAndMatrix;

import java.util.*;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/26 22:10
 * @Describe
 */

class Array06 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length <= 0)
            return nums1;
        if(nums2 == null || nums2.length <= 0)
            return nums2;
        int[] shortArray = nums1.length <= nums2.length ? nums1 : nums2;
        int[] longArray = nums1.length <=nums2.length ? nums2 : nums1;
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int j = 0;
        for(int i = 0 ; i < shortArray.length;i++){
            if(map.containsKey(shortArray[i]))
                j = map.get(shortArray[i])+1;
            else
                j = 0;
            while(j < longArray.length){
                if(shortArray[i] == longArray[j]){
                    list.add(shortArray[i]);
                    map.put(shortArray[i],j);
                }
                j++;
            }
        }
        int[] temp = new int[list.size()];
        for(int i = 0 ; i < list.size();i++)
            temp[i] = list.get(i);
        return temp;
    }
}
