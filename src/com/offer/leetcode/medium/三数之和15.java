package com.offer.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Zeng Zhuo
 * @Date 2020/5/24 23:42
 * @Describe 1.排序
 *           2.双指针移动
 *           3.key:消除重复数组，对重复进行过滤，但注意过滤时注意边界，切勿超出边界引发下标越界。
 */

public class 三数之和15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 采用快速排序
        QuickSort(nums,0,nums.length-1);
        List<List<Integer>> list = new ArrayList<>();
        //采用双指针进行移动判断
        int l = -1,r = -1;
        for(int i = 0 ; i < nums.length;i++){
            l = i+1;
            r = nums.length-1;
            if(nums[i]>0)
                return list;
            if(i>0&&nums[i]==nums[i-1])
                continue;
            while(l<r){
                if(nums[i]+nums[l]+nums[r]>0)
                    r--;
                else if(nums[i]+nums[l]+nums[r]<0)
                    l++;
                else{
                    List<Integer> list1 = (List<Integer>) Arrays.asList(new Integer[]{nums[i],nums[l],nums[r]});
                    list.add(list1);
                    while(l<r&&nums[l] == nums[l+1])
                        l = l+1;
                    l++;
                    while(l<r&&nums[r] == nums[r-1])
                        r = r-1;
                }
            }
        }
        return list;
    }

    public void QuickSort(int[] array,int low,int high){
        if(low<high){
            int pivotpos = partition(array,low,high);
            //对左边进行划分
            QuickSort(array,low,pivotpos-1);
            //对右边进行划分
            QuickSort(array,pivotpos+1,high);
        }
    }

    public int partition(int[] array,int low,int high){
        int pivot = array[low]; //取表中的第一个元素为中心点。
        while(low<high){//low=high的时候退出。
            while(low<high&&array[high]>=pivot)//先从右找小于pivot的数，存到array[low]下。
                high--;
            array[low] = array[high];
            while(low<high&&array[low]<=pivot)//从左找大于pivot的数，存到array[high]上。
                low++;
            array[high] = array[low];
        }
        array[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
        三数之和15 test = new 三数之和15();
        List<List<Integer>> list = test.threeSum(new int[]{0, 0, 0});
        System.out.println(list);
    }
}
