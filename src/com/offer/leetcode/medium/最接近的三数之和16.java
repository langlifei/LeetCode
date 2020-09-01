package com.offer.leetcode.medium;


/**
 * @Author Zeng Zhuo
 * @Date 2020/5/25 17:37
 * @Describe
 */

public class 最接近的三数之和16 {

    public int threeSumClosest(int[] nums, int target) {
        QuickSort(nums,0,nums.length-1);
        int minDistance = Integer.MAX_VALUE;
        //采用双指针进行移动判断
        int l = -1,r = -1;
        for(int i = 0 ; i < nums.length;i++){
            l = i+1;
            r = nums.length-1;
            if(i>0&&nums[i]==nums[i-1])
                continue;
            while(l<r){
                if(nums[i]+nums[l]+nums[r]-Math.abs(target)>Math.abs(minDistance))
                    r--;
                else if(nums[i]+nums[l]+nums[r]-Math.abs(target)<-Math.abs(minDistance))
                    l++;
                else{
                    minDistance = nums[i]+nums[l]+nums[r]-Math.abs(target);
                    l++;
                }
            }
        }
        return Math.abs(target)+minDistance;
    }

    public void QuickSort(int[] array,int low,int high){
        if(low<high){
            int pivotPos = partition(array,low,high);
            //对左边进行划分
            QuickSort(array,low,pivotPos-1);
            //对右边进行划分
            QuickSort(array,pivotPos+1,high);
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
        最接近的三数之和16 test = new 最接近的三数之和16();
        System.out.println(test.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
