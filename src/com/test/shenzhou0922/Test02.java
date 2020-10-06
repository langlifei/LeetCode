package com.test.shenzhou0922;

import com.offer.Sorts.Test;

import java.util.Stack;

public class Test02 {

    public int[] pushIntArray (int[] arr, int pushOffset) {
        // write code here
        if( arr == null || arr.length <= 0 )
            return arr;
        pushOffset %= arr.length;
        if(pushOffset == 0)
            return arr;
        Stack<Integer> stack = new Stack<>();
        for(int i = pushOffset,j = arr.length-1 ; i > 0 && j >= 0; i--,j--)
            stack.push(arr[j]);
        for(int i = arr.length-pushOffset-1; i >= 0; i--)
            arr[i+pushOffset] = arr[i];
        for(int i = 0 ; i < pushOffset; i++)
            arr[i] = stack.pop();
        return arr;
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        test02.pushIntArray(new int[]{1,2,3,4,5,6,7,8,9},2);
    }
}
