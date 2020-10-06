package com.test.shuidi0926;

public class Test02 {

    static int maxsumofSubarray(int[] arr) {
        if( arr == null || arr.length <= 0 )
            return 0;
        int max = arr[0];
        int n = arr.length;
        //采用动态规划dp[j] += Math.max(dp[j-1],0)
        for(int i = 1 ; i < n ; i++){
            if(arr[i-1] > 0)
                arr[i] += arr[i-1];
            else
                arr[i] += 0;
            if(max < arr[i])
                max = arr[i];
        }
        return max;
    }
}
