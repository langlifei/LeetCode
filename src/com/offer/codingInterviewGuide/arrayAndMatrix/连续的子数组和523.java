package com.offer.codingInterviewGuide.arrayAndMatrix;

class Array13 {

    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length <= 0)
            return false;
        int n = nums.length;
        int[] array = new int[n];
        array[0] = nums[0];
        boolean flag = false;
        for(int i = 1; i < n; i++){
            array[i] += array[i-1]+nums[i];
            if(array[i]==0)
                flag = true;
            if(k != 0 && array[i] % k == 0)
                return true;
        }
        if(k==0&&flag)
            return true;
        int temp = 0;
        for(int i = 1 ; i < n-1 ; i++){
            for(int j = i+1; j < n ; j++){
                temp = array[j]-array[i-1];
                if(temp == 0)
                    return true;
                if(k != 0 && temp % k == 0)
                    return true;
            }
        }
        return false;
    }
}
