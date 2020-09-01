package com.offer.codingInterviewGuide.others;

import com.offer.sword.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/19 16:02
 * @Describe
 */

class Other01 {
    public int[][] findContinuousSequence(int target) {
        if(target<=0)
            return null;
        List<int[]> lists = new ArrayList<>();
        int[] tempList = null;
        int i = 1 , j = 2;
        int temp = 0;
        while( i < j && j <= target/2+1){
            temp = (i+j)*(j-i+1)/2;
            if(temp < target)
                j++;
            else if(temp > target)
                i++;
            else{
                int m = i;
                tempList = new int[j-i+1];
                for(int a = 0 ; a < tempList.length&&m<=j;a++)
                    tempList[a] = m++;
                lists.add(tempList);
                j++;
            }
        }
        int[][] res = new int[lists.size()][];
        for (int m = 0; m < res.length; m++) {
            res[m] = lists.get(m);
        }
        return res;
    }

    public static void main(String[] args) {
        Other01 test = new Other01();
        System.out.println(test.findContinuousSequence(15));
    }
}
