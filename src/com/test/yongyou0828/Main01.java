package com.test.yongyou0828;

import java.util.Scanner;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/28 16:51
 * @Describe
 */

class Solution01 {

    public  String[] quick_sort (String[] array) {
        // write code here
        if(array == null || array.length<= 0 )
            return array;
        quickSort(array,0, array.length - 1);
        return array;
    }

    public void quickSort(String[] array,int start , int end){
        if(start < end){
            int pivot = findP(array,start,end);
            quickSort(array,start,pivot-1);
            quickSort(array,pivot+1,end);
        }
    }

    private int findP(String[] array, int start, int end) {
        String pivot = array[start];
        while(start<=end){
            while(start<=end && array[end].compareTo(pivot) > 0)
                end--;
            array[start] = array[end];
            while(start<=end && array[start].compareTo(pivot) < 0)
                start++;
            array[end] = array[start];
        }
        array[start] = pivot;
        return start;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = str.substring(1,str.length()-1);
        String[] array = str.split(",");
        Solution01 s = new Solution01();
        s.quick_sort(array);
    }
}
