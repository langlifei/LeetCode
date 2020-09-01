package com.test.yongyou0828;

import java.util.Scanner;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/28 17:10
 * @Describe
 */

class Solution02 {

    public void print(int[] array){
        if(array == null || array.length <= 0 )
            return ;
        System.out.println("[");
        for(int i = 0 ; i < array.length ; i++)
            System.out.print(array[i]);
        System.out.println("]");
    }

    public int[] merge (int[] one, int[] two) {
        if(one != null || one.length > 0)
            quick_sort(one);
        if(two != null || two.length > 0)
            quick_sort(two);
        int[] three = new int[one.length+two.length];
        int index = 0;
        int i = 0 ;
        int j = 0;
        while( i < one.length && j < two.length){
            if(one[i] < two[j])
                three[index++] = one[i++];
            else
                three[index++] = two[j++];
        }
        while( i < one.length )
            three[index++] = one[i++];
        while ( j < two.length)
            three[index++] = two[j++];
        // write code here
        return three;
    }

    public  int[] quick_sort (int[] array) {
        // write code here
        if(array == null || array.length<= 0 )
            return array;
        quickSort(array,0, array.length - 1);
        return array;
    }

    public void quickSort(int[] array,int start , int end){
        if(start < end){
            int pivot = findP(array,start,end);
            quickSort(array,start,pivot-1);
            quickSort(array,pivot+1,end);
        }
    }

    private int findP(int[] array, int start, int end) {
        int pivot = array[start];
        while(start<end){
            while(start<end && array[end] >= pivot)
                end--;
            array[start] = array[end];
            while(start < end && array[start] <= pivot)
                start++;
            array[end] = array[start];
        }
        array[start] = pivot;
        return start;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int index = 0;
        char c = ' ';
        while(index < str.length()){
            c = str.charAt(index);
            if( c == ']')
                break;
            index++;
        }
        String str1 = str.substring(1,index);
        String str2 = str.substring(index+3,str.length()-1);
        String[] str1s = str1.split(",");
        String[] str2s = str2.split(",");
        int[] one = new int[str1s.length];
        for(int i = 0 ; i < str1s.length ; i++)
            one[i] = Integer.parseInt(str1s[i]);
        int[] two = new int[str2s.length];
        for(int i = 0 ; i < str2s.length ; i++)
            two[i] = Integer.parseInt(str2s[i]);
        Solution02 s = new Solution02();
        s.merge(one,two);
    }
}
