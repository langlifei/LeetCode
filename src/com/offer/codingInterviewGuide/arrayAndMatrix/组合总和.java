package com.offer.codingInterviewGuide.arrayAndMatrix;

import java.util.ArrayList;
import java.util.List;

class Array11 {

    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if( candidates==null || candidates.length <= 0 || target <= 0 )
            return lists;
        int len = candidates.length;
        int[][] dp = new int[len][len];
        for(int i = 0 ; i < len ; i++){
            
        }
        return null;
    }
}
