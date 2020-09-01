package com.offer.leetcode.sword.easy;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/6 18:10
 * @Describe key:有序数组使用二分法
 *               性质：左排序数组中任一元素大于右排序数组中任一元素
 *               1.如果mid>high,则旋转点x在[mid+1,high]
 *               2.如果mid<high,则x在[low,mid]
 *               3.如果mid==high,则high--;
 */

public class 旋转数组的最小数字11 {

    public int minArray(int[] numbers) {
        int low = 0, mid = 0,high = numbers.length-1;
        while(low<high){
            mid = (low+high)/2;
            if(numbers[mid]>numbers[high])
                low = mid+1;
            else if(numbers[mid]<numbers[high])
                high = mid;
            else
                high = high-1;
        }
        return numbers[low];
    }
}
