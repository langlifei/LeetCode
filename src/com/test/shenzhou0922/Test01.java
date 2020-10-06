package com.test.shenzhou0922;

import com.offer.Sorts.Test;

public class Test01 {
    public int sort (String inData) {
        // write code here
        if( inData == null || inData.length() <= 0 )
            return 0;
        String[] oriData = inData.split(" ");
        int[] array = new int[oriData.length];
        for(int i = 0 ; i < array.length ; i++)
            array[i] = Integer.parseInt(oriData[i]);
        int steps = 0;
        int temp = 0;
        int i,j;
        for(i = 0 ; i < array.length-1;i++){
            if(array[i]>array[i+1]){
                temp = array[i];
                for(j = i+1;j<array.length-1&&array[j]<=temp;j++){
                    array[j] = array[j+1];
                    steps++;
                }
                array[j] = temp;
            }
        }
        return steps;
    }

    public void sort(int[] array){
        int temp = 0;
        int i,j;
        for(i = 1 ; i < array.length;i++){
            if(array[i]<array[i-1]){
                temp = array[i];
                for(j = i-1;j>=0&&array[j]>temp;j--){
                    array[j+1] = array[j];
                }
                array[j+1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        System.out.println(test01.sort("19 5 9 255 123 123 1 -123 -123 12 -12 -3 -43"));
    }
}
