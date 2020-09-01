package com.offer.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 *                          时间：2020年3月16日13:31:33
 *                          地点：湖北省仙桃市
 *                          结果：(81ms,10.49%);(39.6mb,5.05%)
 */

public class TwoSum01 {

    public  int[] twoSum(int[] nums,int target){
        int index = 0;
        for(int i = 0 ; i < nums.length;i++){
            if(target/2>=nums[i]){
                index = getIndex(nums,target-nums[i],i);
                if(index != -1){
                    int a = i>index?i:index;//a为较大的坐标
                    int b = i < index?i:index;//b为较小的坐标
                    return new int[]{b,a};
                }
            }
        }
        return null;
    }

    public int getIndex(int[] nums,int mid,int index){
        for(int i = 0 ; i < nums.length;i++){
            if(nums[i]==mid&&i!=index)
                return i;
        }
        return -1;
    }

    /**
     * @result (3ms,93.50%);(42mb,5.06%)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        int temp = 0;
        for(int i = 0; i < nums.length;i++)
            map.put(nums[i],i);
        for(int i = 0; i < nums.length;i++){
            temp = target - nums[i];
            if(map.containsKey(temp)&&map.get(temp)!=i)
                return new int[]{i,map.get(temp)};//
        }
        return null;
    }

    /**
     * @result (2ms,99.58%);(40mb,5.06%),对比上一个函数，优化了一点存储并减少了执行时间。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        int temp = 0;
        int mid = target/2;
        int index = -1;
        //只存储比目标值的一半小于等于的数
        for(int i = 0; i < nums.length;i++){
            if(mid>=nums[i]){
                map.put(nums[i],i);
            }
        }
        for(int i = 0; i < nums.length;i++){
            temp = target - nums[i];
            if(mid >= temp) {
                if (map.containsKey(temp) && (index = map.get(temp)) != i) {
                    int a = i > index ? i : index;//a为较大的坐标
                    int b = i < index ? i : index;//b为较小的坐标
                    return new int[]{b, a};
                }
            }
        }
        return null;
    }

    /**
     * @result (3ms,93.50%);(41.6mb,5.06%);
     * @param nums
     * @param target
     * @return
     */
        public int[] twoSum3(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            int complement = 0;
            for (int i = 0; i < nums.length; i++) {
                complement = target - nums[i];
                //因为当前i的值还为存入，所以不用担心出现重复。
                if (map.containsKey(complement)) {
                    return new int[] { map.get(complement), i }; //先存入的下标小，放在前面。
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
}
