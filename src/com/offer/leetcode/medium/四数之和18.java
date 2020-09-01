package com.offer.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Zeng Zhuo
 * @Date 2020/5/26 21:51
 * @Describe
 */

public class 四数之和18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new LinkedList<>();
        if(nums.length<=0)
            return list;
        //对数组进行排序
        //quickSort(nums,0,nums.length-1);
        Arrays.sort(nums);
        //借助三数之和的排序+双指针的思想，将四个数中，a+b看成是一个数。
        int t = 0 , l = 0 , r = 0,temp = 0;
        for(int i = 0 ; i < nums.length;i++){
            //由于排过序，如果第一个数大于目标值，那么四个数的结果一定大于目标值，故直接返回已保存的集合
            if(nums[i]>Math.abs(target))
                return list;
            //如果重复那么跳过。。。。。
            if(i>0&&nums[i]==nums[i-1])
                continue;
            for(t = i+1;t<nums.length;t++){
                l = t+1;
                r = nums.length-1;
                //将a+b看做一个数，实现四数之和
                if(nums[i]+nums[t]>Math.abs(target))
                    break;
                if(t-1!=i&&nums[t]==nums[t-1])
                    continue;
                while(l<r){
                    temp = nums[i]+nums[t]+nums[l]+nums[r];
                    //如果发现四数之和大于目标数，那么将四数之和减少，即r向右移,如果小于，则l向左移
                    if(temp>target){
                        r--;
                    }
                    else if(temp<target)
                        l++;
                    else{
                        List<Integer> list1 = Arrays.asList(new Integer[]{nums[i],nums[t],nums[l],nums[r]});
                        list.add(list1);
                        //如果有相同的，那么直接到最后一个，只计算一次
                        while(l<r&&nums[l]==nums[l+1])
                            l++;
                        while(l<r&&nums[r]==nums[r-1])
                            r--;
                        l++;
                    }
                }
            }
        }
        return list;
    }

    public void quickSort(int[] array,int start,int end){
        if(start>end)
            return;
        //进行切分，寻找到pivot点
        int pivotPos = partition(array,start,end);
        //对左边的数组进行quickSort,
        quickSort(array,0,pivotPos-1);
        //对右边的数组进行quickSort
        quickSort(array,pivotPos+1,end);
    }

    private int partition(int[] array,int start,int end) {
        int pivot = array[start];
        while(start < end){
            while(start<end&&array[end]>=pivot)
                end--;
            array[start] = array[end];
            while(start<end&&array[start]<=pivot)
                start++;
            array[end] = array[start];
        }
        array[start] = pivot;
        return start;
    }

    public static void main(String[] args) {
        四数之和18 test = new 四数之和18();
        System.out.println(test.fourSum(new int[]{-493,-482,-482,-456,-427,-405,-392,
                -385,-351,-269,-259,-251,-235,-235,-202,-201,-194,-189,-187,-186,-180,
                -177,-175,-156,-150,-147,-140,-122,-112,-112,-105,-98,-49,-38,-35,-34,
                -18,20,52,53,57,76,124,126,128,132,142,147,157,180,207,227,274,296,311,
                334,336,337,339,349,354,363,372,378,383,413,431,471,474,481,492
        }, 6189));
    }
}
