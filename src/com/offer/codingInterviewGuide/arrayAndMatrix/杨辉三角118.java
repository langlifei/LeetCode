package com.offer.codingInterviewGuide.arrayAndMatrix;

import com.offer.sword.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/25 17:05
 * @Describe
 */

class Array05 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if(numRows<=0)
            return lists;
        Integer[][] data = new Integer[numRows][];
        Integer[] temp = null;
        for(int i = 0 ; i < numRows; i++){
            temp = new Integer[i+1];
            for(int j = 0 ; j < temp.length ; j++){
                if( j == 0 || j == temp.length-1){
                    temp[j] = 1;
                    continue;
                }
                temp[j] = data[i-1][j-1]+data[i-1][j];
            }
            data[i] = temp;
            lists.add(Arrays.asList(temp));
        }
        return lists;
    }
}
