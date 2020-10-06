package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XJ0917 {


    public List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length <= 0)
            return list;
        dfs(list,nums,0);
        return list;
    }

    public void dfs(List<List<Integer>> list , int[] nums , int n){
        if( n == nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        //选当前节点
        temp.add(nums[n]);
        dfs(list,nums,n+1);
        //不选当前节点
        temp.remove((Integer) nums[n]);
        dfs(list,nums,n+1);
    }
}
