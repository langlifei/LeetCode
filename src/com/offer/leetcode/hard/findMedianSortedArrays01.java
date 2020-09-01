package com.offer.leetcode.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class findMedianSortedArrays01 {

    /**
     * @result (8ms,10.08%);(42.6mb,96.33%);
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0 ;
        int j = 0;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        if(nums1!=null&&nums2!=null)
            while(i < nums1.length&&j<nums2.length){
                if(nums1[i]<nums2[j]){
                    map.put(count++,nums1[i++]);
                }else{
                    map.put(count++,nums2[j++]);
                }
            }
        int mid = 0;
        int totalLength = 0;
        if(nums1!=null&&nums2!=null){
            mid = (nums1.length+nums2.length)/2;
            totalLength = nums1.length+nums2.length;
        }
        else if (nums1==null){
            mid = nums2.length/2;
            totalLength = nums2.length;
        }
        else if(nums2==null){
            mid = nums1.length/2;
            totalLength = nums1.length;
        }
        int[] temp = null;
        int m = 0;
        if(count <= mid){
            if(nums1!=null&&i==nums1.length){
                m = j;
                temp = nums2;
            }else if(nums1==null){
                m = j;
                temp = nums2;
            } else{
                m = i;
                temp = nums1;
            }
        }
        while(count<=mid&&m<temp.length){
            map.put(count++,temp[m++]);
        }
        //除以浮点数，转换为浮点数。
        if(totalLength%2==0)
            return (map.get(mid-1)+map.get(mid))/2.0;
        else
            return map.get(mid)/1.0;
    }

    /**
     * @note 参考leetcode官方解题思想
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] temp;
        int t = 0;
        int m = nums1.length;
        int n = nums2.length;
        //使得j不为负数，数组下标越界，得确保n不小于m
        if(m > n){
            temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            t = m;
            m = n;
            n = t;
        }
        //对i和j进行初始化。
        int imin = 0;
        int imax = m;
        int i = 0;
        int halfLen = (m+n+1)/2;
        int j = 0;//j会随着i增大而减小。
        //寻找到i,从而找出中位数，当i变化时，j跟随i进行变化，可确保第一个条件成立。
        while(imin<=imax){
            i = (imin+imax)/2;
            j = halfLen - i;
            if(i<imax&&nums2[j-1]>nums1[i]){//表示j太大，故j需减小，故只需将i增大即可，前面的判断是为了当找到边界时跳到第三种情况，而不是像二分查找一样跳出循环。
                imin = i+1;
            }else if(i>imin&&nums1[i-1]>nums2[j]){//表示i太大，故i需减小。
                imax = i-1;
            }else{//表明寻找到合适的i，可以得到其中位数。
                //如果m+n是奇数，则取左边部分的最大值即可,否则返回左边最大+右边最小/2.0，除2.0转换为double类型。
                //判断边界情况。
                double max_left = 0.0;
                if(i==0){ //表示nums1在左边集合中为空集
                    max_left = nums2[j-1];
                }else if(j==0){//表示nums2在左边集合中为空集
                    max_left = nums1[i-1];
                }else{
                    max_left = Math.max(nums1[i-1],nums2[j-1]);
                }
                if((m+n)%2!=0)    //m+n为奇数直接返回左边最大的。
                    return max_left;

                double min_right = 0.0;
                if(i==m) //左边nums1为满集
                    min_right = nums2[j];
                else if(j==n)//左边nums2为满集
                    min_right = nums1[i];
                else
                    min_right = Math.min(nums1[i],nums2[j]);
                return (max_left+min_right)/2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args){
        System.out.println(new findMedianSortedArrays01().findMedianSortedArrays1(null,new int[]{3,4}));
    }
}
